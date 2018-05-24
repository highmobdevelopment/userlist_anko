package erevacation.com.userlistanko.homescreen.profile

import android.graphics.Color
import android.provider.ContactsContract
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import erevacation.com.userlistanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class AnkoViewHolderProfileUI: AnkoComponent<ViewGroup> {

    lateinit var icon: ImageView
    lateinit var cardName: TextView
    lateinit var profileDetails: TextView
    lateinit var shadowView: View

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            frameLayout {
                constraintLayout {
                    backgroundColor = Color.WHITE
                    isClickable = true
                    isFocusable = true
                    minHeight = dip(56)

                    icon = imageView(){
                        id = R.id.item_icon
                        setImageResource(R.drawable.email)

                    }.lparams(width=dip(32),height = dip(32)){
                        marginStart = dip(8)
                        bottomMargin = dip(8)
                        topMargin = dip(8)
                        bottomToBottom = PARENT_ID
                        startToStart = PARENT_ID
                        topToTop = PARENT_ID
                    }

                    cardName = textView(){
                        id = R.id.item_name
                        textSize = 12f
                    }.lparams(width = wrapContent, height = wrapContent){
                        startToEnd = R.id.item_icon
                        bottomToBottom = R.id.item_details
                        topToTop = PARENT_ID
                        bottomMargin = dip(8)
                        marginStart = dip(24)
                    }

                    profileDetails = textView(){
                        id = R.id.item_details
                        textSize = 16f
                        textColor = Color.BLACK
                    }.lparams(width = wrapContent,height = wrapContent){
                        bottomToBottom = PARENT_ID
                        topToTop = PARENT_ID
                        startToEnd = R.id.item_icon
                        marginStart = dip(24)
                        topMargin = dip(8)
                    }

                    shadowView = view(){
                        id = R.id.shadow_view_details
                        backgroundColor = Color.LTGRAY

                    }.lparams(width = wrapContent, height = dip(0.5f)){
                        bottomToBottom = PARENT_ID
                        startToEnd = R.id.item_icon
                    }
                }.lparams(width = matchParent,height = wrapContent){
                 marginEnd = dip(32)
                }
            }

        }
    }

}