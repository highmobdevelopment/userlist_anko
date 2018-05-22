package erevacation.com.userlistanko.homescreen

import erevacation.com.userlistanko.basic.arhitecture.ViperContract


interface HomeContract {

    interface HomeView : ViperContract.View<HomePresenter> {

    }

    interface HomePresenter : ViperContract.Presenter {
        fun buildLayout()
    }
}