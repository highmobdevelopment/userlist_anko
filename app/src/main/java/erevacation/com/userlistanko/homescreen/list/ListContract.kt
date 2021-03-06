package erevacation.com.userlistanko.homescreen.list

import erevacation.com.userlistanko.basic.arhitecture.ViperContract


interface ListContract {
    interface ListView : ViperContract.View<ListPresenter> {

    }
    interface ListPresenter : ViperContract.Presenter {
        fun onContactClick(name: String, surname: String, image: String, profileInfoList: ArrayList<String>)
    }
}