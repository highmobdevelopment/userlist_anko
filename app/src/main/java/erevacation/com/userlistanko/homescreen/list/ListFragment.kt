package erevacation.com.userlistanko.homescreen.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import erevacation.com.userlistanko.basic.BasicFragment
import erevacation.com.userlistanko.homescreen.HomeActivity
import org.jetbrains.anko.AnkoContext

class ListFragment : BasicFragment<ListContract.ListPresenter>(), ListContract.ListView {

    val ankoFragmentListUI: AnkoFragmentListUI = AnkoFragmentListUI()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View = ankoFragmentListUI.createView(AnkoContext.Companion.create(activity as HomeActivity, this))

    companion object {

        fun newInstance(): ListFragment {

            val fragment = ListFragment()

            return fragment
        }
    }
}
