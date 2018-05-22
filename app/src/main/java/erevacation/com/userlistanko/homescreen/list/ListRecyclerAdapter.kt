package erevacation.com.userlistanko.homescreen.list

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import erevacation.com.userlistanko.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class ListRecyclerAdapter(val presenter: ListFragmentPresenter) : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    private val listInfo: MutableList<String> = mutableListOf("one", "two", "three", "four", "five")
    @SuppressLint("PrivateResource")
    private val listImage: MutableList<Int> = mutableListOf(R.drawable.ic_account_circle_black_24dp,
            R.drawable.notification_bg_low_normal,
            R.drawable.abc_ic_star_black_36dp,
            R.drawable.ic_account_circle_black_24dp,
            R.drawable.abc_ic_star_black_36dp)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder? {
        val itemView = AnkoViewHolderListUI().createView(AnkoContext.create(parent.context, parent))
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listInfo[position], listImage[position])
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var profileText: TextView = itemView.find(R.id.profile_text_viewholder)
        val profileImage: ImageView = itemView.find(R.id.profile_circle_image_viewholder)

        fun bind(list: String, image: Int) {
            profileText.text = list
            profileImage.setImageResource(image)
        }
    }

}







