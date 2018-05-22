package erevacation.com.userlistanko.homescreen


import android.app.FragmentManager
import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import erevacation.com.userlistanko.homescreen.adapter.ViewPagerAdapter
import erevacation.com.userlistanko.homescreen.list.ListFragment
import erevacation.com.userlistanko.homescreen.list.ListFragment.Companion.newInstance
import javax.inject.Inject

class HomeActivityPresenter @Inject constructor() : HomeContract.HomePresenter {


    private val TAG: String = "HomeActivityPresenter"
    private var view: HomeContract.HomeView? = null
    private lateinit var fragmentManager: FragmentManager
    private var listFragment: ListFragment = newInstance()
    private var adapter: ViewPagerAdapter? = null


    // overrides that every presenter have
    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as HomeContract.HomeView
        fragmentManager = (this.view as HomeActivity).fragmentManager
        adapter = ViewPagerAdapter((view as HomeActivity).supportFragmentManager)
        setupViewPager()
        buildLayout()
    }

    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
    }

    override fun buildLayout() {

    }

    private fun setupViewPager() {
        adapter?.addFragment(listFragment)
        (view as HomeActivity).ankoHomeUI.viewPager?.adapter = adapter
    }
}