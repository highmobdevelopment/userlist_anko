package erevacation.com.userlistanko.homescreen.profile

import erevacation.com.userlistanko.basic.arhitecture.ViperContract

interface ProfileContract {
    interface ProfileView : ViperContract.View<ProfilePresenter> {

    }
    interface ProfilePresenter : ViperContract.Presenter {

    }
}