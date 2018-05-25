package erevacation.com.userlistanko.homescreen.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import erevacation.com.userlistanko.basic.BasicFragment
import erevacation.com.userlistanko.homescreen.HomeActivity
import org.jetbrains.anko.AnkoContext

class ProfileFragment : BasicFragment<ProfileContract.ProfilePresenter>(), ProfileContract.ProfileView {

    val ankoFragmentProfileUI: AnkoFragmentProfileUI = AnkoFragmentProfileUI()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View = ankoFragmentProfileUI.createView(AnkoContext.Companion.create(activity as HomeActivity, this))

    var name: String = ""
    var surname: String = ""
    var image: String = ""
    var profileInfoList: ArrayList<String> = arrayListOf()

    override fun onStart() {
        this.name = arguments!!.getString(NAME)
        this.surname = arguments!!.getString(SURNAME)
        this.image = arguments!!.getString(IMAGE)
        this.profileInfoList = arguments!!.getStringArrayList(PROFILEINFOLIST)
        super.onStart()
    }

    companion object {
        private val NAME = "name"
        private val SURNAME = "surname"
        private val IMAGE = "image"
        private val PROFILEINFOLIST = "profileInfoList"
        const val PROFILE_FRAGMENT_TAG: String = "PROFILE_FRAGMENT_TAG"
        fun newInstance(name: String, surname: String, image: String, profileInfoList: ArrayList<String>): ProfileFragment {

            val args: Bundle = Bundle()
            args.putStringArrayList(PROFILEINFOLIST, profileInfoList)
            args.putSerializable(NAME, name)
            args.putSerializable(SURNAME, surname)
            args.putSerializable(IMAGE, image)
            val fragment = ProfileFragment()
            fragment.arguments = args
            return fragment
        }
    }
}