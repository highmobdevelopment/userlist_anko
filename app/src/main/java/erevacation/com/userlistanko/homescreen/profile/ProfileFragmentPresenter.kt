package erevacation.com.userlistanko.homescreen.profile

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import erevacation.com.userlistanko.basic.arhitecture.ViperContract
import javax.inject.Inject

class ProfileFragmentPresenter @Inject constructor() : ProfileContract.ProfilePresenter {


    private var view: ProfileContract.ProfileView? = null
    private val profileAdapter = ProfileRecyclerAdapter(this)

    override fun viewAttach(view: ViperContract.View<*>) {
        this.view = view as ProfileContract.ProfileView
        view as ProfileFragment
        setUserNameAndImage(view.name, view.surname, view.image, view.profileInfoList, view.ankoFragmentProfileUI)
        buildLayout()
    }

    override fun viewDetach() {
        this.view = null
    }

    override fun onDestroyed() {
        this.view = null
    }

    private fun setUserNameAndImage(name: String, surname: String, image: String, profileInfoList: ArrayList<String>, ankoFragment: AnkoFragmentProfileUI) {
        val fullName: String = "$name $surname"
        ankoFragment.fullName.text = fullName
        ankoFragment.profileImage.let { Glide.with(it.context).load(image).apply(RequestOptions.circleCropTransform()).into(it) }
        profileAdapter.updateUserDetails(profileInfoList)
    }

    private fun buildLayout() {
        (view as ProfileFragment).ankoFragmentProfileUI.recyclerViewProfile.adapter = profileAdapter
    }
}