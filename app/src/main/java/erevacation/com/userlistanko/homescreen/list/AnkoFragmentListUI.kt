package erevacation.com.userlistanko.homescreen.list

import android.graphics.Color
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import erevacation.com.userlistanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class AnkoFragmentListUI : AnkoComponent<ListFragment> {
    var recyclerViewList: RecyclerView? = null
    lateinit var text: TextView
    lateinit var image: ImageView
    override fun createView(ui: AnkoContext<ListFragment>): View = with(ui) {

        frameLayout() {
            constraintLayout() {
                id = R.id.list_fragment_anko

                recyclerViewList = recyclerView {
                    id = R.id.list_recycler_view_anko
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    backgroundColor = Color.RED

                }.lparams(width = 0, height = 0) {
                        topToTop = PARENT_ID
                        leftToLeft = PARENT_ID
                        rightToRight = PARENT_ID
                        bottomToBottom = PARENT_ID

                }
            }.lparams(width = matchParent, height = matchParent)

        }


    }
}



