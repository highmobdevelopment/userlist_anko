package erevacation.com.userlistanko.homescreen.profile

import android.graphics.Color
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import erevacation.com.userlistanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class AnkoFragmentProfileUI : AnkoComponent<ProfileFragment> {

    lateinit var recyclerViewProfile: RecyclerView
    lateinit var profileImage: ImageView
    lateinit var fullName: TextView
    lateinit var profileUnderline: View
    override fun createView(ui: AnkoContext<ProfileFragment>): View = with(ui) {

        frameLayout() {
            constraintLayout() {
                id = R.id.profile_fragment_anko
                backgroundColor = Color.WHITE
                isClickable = true
                isFocusable = true

                relativeLayout {
                    id = R.id.profile_background
                    backgroundResource = R.drawable.profile_background
                }.lparams(width = matchParent, height = dip(140)) {
                    endToEnd = PARENT_ID
                    startToStart = PARENT_ID
                    topToTop = PARENT_ID
                }

                profileImage = imageView() {
                    id = R.id.profile_image
                    padding = dip(8)
                    backgroundResource = R.drawable.circle_frame
                    scaleType = ImageView.ScaleType.CENTER_CROP
                }.lparams(width = dip(140), height = dip(140)) {
                    endToEnd = PARENT_ID
                    startToStart = PARENT_ID
                    topToTop = PARENT_ID
                    marginEnd = dip(8)
                    marginStart = dip(8)
                    topMargin = dip(72)
                }

                fullName = textView() {
                    id = R.id.profile_full_name
                    textSize = 20f
                    textColor = R.color.colorPrimary
                    gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(width = wrapContent, height = wrapContent) {
                    endToEnd = PARENT_ID
                    startToStart = PARENT_ID
                    topToBottom = R.id.profile_image
                    marginEnd = dip(8)
                    marginStart = dip(8)
                    topMargin = dip(8)
                }

                profileUnderline = view() {
                    id = R.id.profile_underline
                    backgroundColor = R.color.colorPrimary
                }.lparams(width = matchParent, height = dip(1.5f)) {
                    endToEnd = PARENT_ID
                    startToStart = PARENT_ID
                    bottomToTop = R.id.recycler_container
                    marginEnd = dip(16)
                    marginStart = dip(16)
                }

                relativeLayout {
                    backgroundColor = Color.WHITE
                    id = R.id.recycler_container
                    recyclerViewProfile = recyclerView {
                        id = R.id.profile_recycler_view_anko
                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        backgroundColor = Color.WHITE
                        isFocusableInTouchMode = true

                    }.lparams(width = matchParent, height = matchParent){

                    }
                }.lparams(width = matchParent,height = wrapContent){
                    topToBottom = R.id.profile_full_name
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    topMargin = dip(8)
                }

            }.lparams(width = matchParent, height = matchParent) {

            }

        }


    }
}