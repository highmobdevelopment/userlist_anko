package erevacation.com.userlistanko.datamanager

import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import erevacation.com.userlistanko.datamodel.ListDM
import io.reactivex.Observable

interface ListDataManagerContract : ViperContract.DataManager {

    fun getList(): Observable<MutableList<ListDM>>
}