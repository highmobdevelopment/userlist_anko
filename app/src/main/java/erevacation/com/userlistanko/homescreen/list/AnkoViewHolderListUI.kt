package erevacation.com.userlistanko.homescreen.list

import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import erevacation.com.userlistanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class AnkoViewHolderListUI : AnkoComponent<ViewGroup> {
    var profileImage: ImageView? = null
    var profileText: TextView? = null
    var shadowView: View? = null

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            frameLayout {

                constraintLayout() {
                    backgroundColor = Color.WHITE

                    profileImage = imageView() {

                        id = R.id.profile_circle_image_viewholder
                    }.lparams(width = dip(64), height = dip(64)) {
                        marginStart = dip(8)
                        topMargin = dip(8)
                        bottomMargin = dip(8)
                        leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                        topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                        bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    }
                    profileText = textView() {

                        id = R.id.profile_text_viewholder
                        text = "Test Text"
                        textSize = 24f
                    }.lparams(width = wrapContent, height = wrapContent) {
                        marginStart = dip(32)
                        topMargin = dip(8)
                        bottomMargin = dip(8)
                        topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                        bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                        startToEnd = R.id.profile_circle_image_viewholder
                    }
                    shadowView = view() {

                        id = R.id.shadow_view_anko_viewholder
                        backgroundColor = Color.LTGRAY

                    }.lparams(width = wrapContent, height = 2) {
                        bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                        startToEnd = R.id.profile_circle_image_viewholder
                    }


                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }
}