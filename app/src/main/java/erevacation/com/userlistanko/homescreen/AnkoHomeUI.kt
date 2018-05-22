package erevacation.com.userlistanko.homescreen

import android.support.constraint.ConstraintLayout
import android.support.design.widget.AppBarLayout
import android.support.v4.view.ViewPager
import erevacation.com.userlistanko.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.viewPager

class AnkoHomeUI : AnkoComponent<HomeActivity> {

    var viewPager: ViewPager? = null
    override fun createView(ui: AnkoContext<HomeActivity>) = with(ui) {

        frameLayout {
            id = R.id.home_anko_ui
            constraintLayout {
                coordinatorLayout {
                    viewPager = viewPager {
                        id = R.id.viewpager_anko
                    }.lparams(width = matchParent, height = matchParent) {
                        behavior = AppBarLayout.ScrollingViewBehavior()
                    }
                }.lparams(width = matchParent, height = matchParent) {
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                }
            }.lparams(width = matchParent, height = matchParent)

        }

    }
}