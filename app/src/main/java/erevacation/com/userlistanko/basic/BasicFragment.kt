package erevacation.com.userlistanko.basic

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.Loader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import erevacation.com.userlistanko.basic.arhitecture.ViperPresenterLoader
import javax.inject.Inject

abstract class BasicFragment<P : ViperContract.Presenter> : Fragment(), ViperContract.View<P> {
    private val LOADER_ID = 1234

    protected var loader: Loader<P>? = null
    protected var presenter: P? = null

    @Inject
    lateinit var lazyPrezenter: dagger.Lazy<P>


    override fun onLoaderReset(loader: Loader<P>) {
        this.presenter = null
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<P> {
        return ViperPresenterLoader<P>(context!!)
    }

    override fun onLoadFinished(loader: Loader<P>, pres: P?) {
        if (pres == null) {
            presenter = lazyPrezenter.get()
            (loader as? ViperPresenterLoader<P>)?.presenter = presenter
        } else {
            presenter = pres
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        loader = loaderManager.getLoader<P>(LOADER_ID)
        if (loader == null) {
            loaderManager.initLoader(LOADER_ID, savedInstanceState, this)
        } else {
            presenter = (loader as? ViperPresenterLoader<P>)?.presenter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //return binding?.root
        return view

    }

    override fun onStart() {
        super.onStart()
        presenter?.viewAttach(this)
    }

    override fun onStop() {
        super.onStop()
        presenter?.viewDetach()
    }


}
