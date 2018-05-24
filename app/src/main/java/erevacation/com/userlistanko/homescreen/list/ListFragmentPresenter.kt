package erevacation.com.userlistanko.homescreen.list

import android.support.v4.app.FragmentManager
import erevacation.com.userlistanko.R
import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import erevacation.com.userlistanko.datamodel.ListDM
import erevacation.com.userlistanko.homescreen.HomeActivity
import erevacation.com.userlistanko.homescreen.profile.ProfileFragment
import erevacation.com.userlistanko.usecase.ListUC
import erevacation.com.userlistanko.usecase.ListUCContract
import javax.inject.Inject

class ListFragmentPresenter @Inject constructor(val listUC: ListUC) : ListContract.ListPresenter, ListUCContract.ListUCOut {


    private var view: ListContract.ListView? = null
    private val listAdapter = ListRecyclerAdapter(this)
    private lateinit var fragmentManager: FragmentManager

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ListContract.ListView
        this.listUC.setListUCOut(this)
        fragmentManager = ((view as ListFragment).context as HomeActivity).supportFragmentManager
        listUC.getList()
        buildLayout()

    }

    override fun publishListResults(list: MutableList<ListDM>) {
        listAdapter.updateList(list)
    }

    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
    }

    override fun onContactClick(name: String, surname: String, image: String, profileInfoList: ArrayList<String>) {
        val fragmentProfile = ProfileFragment.newInstance(name, surname, image, profileInfoList)

        fragmentManager.beginTransaction()
                .setCustomAnimations(R.animator.right_in, R.animator.fui_slide_out_left, R.animator.fui_slide_in_right, R.animator.right_out)
                .add(R.id.container, fragmentProfile)
                .addToBackStack("contacts_back_stack")
                .commit()
    }

    private fun buildLayout() {
        (view as ListFragment).ankoFragmentListUI.recyclerViewList.adapter = listAdapter
    }


}