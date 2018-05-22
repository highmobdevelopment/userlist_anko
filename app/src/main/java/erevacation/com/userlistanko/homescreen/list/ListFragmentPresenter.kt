package erevacation.com.userlistanko.homescreen.list

import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import javax.inject.Inject

class ListFragmentPresenter @Inject constructor() : ListContract.ListPresenter {

    private var view: ListContract.ListView? = null
    private val listAdapter = ListRecyclerAdapter(this)

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ListContract.ListView
        buildLayout()
    }

    override fun viewDetach() {

    }

    override fun onDestroyed() {

    }

    private fun buildLayout() {
        (view as ListFragment).ankoFragmentListUI.recyclerViewList?.adapter = listAdapter
    }


}