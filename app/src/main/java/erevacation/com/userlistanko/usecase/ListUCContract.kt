package erevacation.com.userlistanko.usecase

import erevacation.com.userlistanko.datamodel.ListDM


interface ListUCContract {
    fun getList()
    fun setListUCOut(ListUCOut: ListUCOut)
    fun clearRequests()
    interface ListUCOut {
        fun publishListResults(list: MutableList<ListDM>)
    }
}