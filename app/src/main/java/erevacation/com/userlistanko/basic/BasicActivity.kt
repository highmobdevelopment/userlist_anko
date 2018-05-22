package erevacation.com.userlistanko.basic

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import erevacation.com.userlistanko.basic.arhitecture.ViperPresenterLoader
import javax.inject.Inject

abstract class BasicActivity<P : ViperContract.Presenter> : AppCompatActivity(), ViperContract.View<P>, HasSupportFragmentInjector {

    private val LOADER_ID = 1234

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    protected var loader: Loader<P>? = null
    protected var presenter: P? = null

    @Inject
    lateinit var lazyPrezenter: dagger.Lazy<P>

    override fun onLoaderReset(loader: Loader<P>) {
        this.presenter = null
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<P> {
        return ViperPresenterLoader<P>(applicationContext)
    }

    override fun onLoadFinished(loader: Loader<P>, pres: P?) {
        if (pres == null) {
            presenter = lazyPrezenter.get()
            (loader as? ViperPresenterLoader<P>)?.presenter = presenter
            presenter?.viewAttach(this)
        } else {
            presenter = pres
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        loader = supportLoaderManager.getLoader<P>(LOADER_ID)
        if (loader == null) {
            supportLoaderManager.initLoader(LOADER_ID, savedInstanceState, this)
        } else {
            presenter = (loader as? ViperPresenterLoader<P>)?.presenter
            presenter?.viewAttach(this)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.viewDetach()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

}
