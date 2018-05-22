package erevacation.com.userlistanko.homescreen


import android.os.Bundle
import erevacation.com.userlistanko.basic.BasicActivity
import org.jetbrains.anko.setContentView


class HomeActivity : BasicActivity<HomeContract.HomePresenter>(), HomeContract.HomeView {

    val ankoHomeUI: AnkoHomeUI = AnkoHomeUI()
    private val TAG: String = HomeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ankoHomeUI.setContentView(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}