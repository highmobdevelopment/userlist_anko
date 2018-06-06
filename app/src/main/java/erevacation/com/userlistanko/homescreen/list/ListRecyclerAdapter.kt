package erevacation.com.userlistanko.homescreen.list

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.TimingLogger
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import erevacation.com.userlistanko.R
import erevacation.com.userlistanko.datamodel.ListDM
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class ListRecyclerAdapter(val presenter: ListFragmentPresenter) : RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    private val listInfo: MutableList<ListDM> = mutableListOf()
    private val profileInfoList: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder? {
        val timings = TimingLogger(ListRecyclerAdapter::class.java.simpleName, "onCreateViewHolder")
        val itemView = AnkoViewHolderListUI().createView(AnkoContext.create(parent.context, parent))
        timings.addSplit("onCreateViewHolder done")
        timings.dumpToLog()
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listInfo[position].name,
                listInfo[position].surname,
                listInfo[position].image)

        holder.listCard.setOnClickListener {
            this.profileInfoList.clear()
            this.profileInfoList.add(listInfo[position].contactDetails.email)
            this.profileInfoList.add(listInfo[position].contactDetails.address)
            this.profileInfoList.add(listInfo[position].contactDetails.phones.home)
            this.profileInfoList.add(listInfo[position].contactDetails.phones.work)

            presenter.onContactClick(listInfo[position].name
                    ,listInfo[position].surname
                    ,listInfo[position].image
                    ,profileInfoList)
        }
    }

    override fun getItemCount(): Int {
        return listInfo.size
    }

    fun updateList(contacts: MutableList<ListDM>) {
        this.listInfo.clear()
        this.listInfo.addAll(contacts)
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listCard: ConstraintLayout = itemView.find(R.id.list_card)
        private var profileText: TextView = itemView.find(R.id.profile_text_viewholder)
        private val profileImage: ImageView = itemView.find(R.id.profile_circle_image_viewholder)

        fun bind(name: String, surname: String, image: String) {
            val fullName: String = "$name $surname"
            profileText.text = fullName
            profileImage.let { Glide.with(profileImage.context).load(image).apply(RequestOptions.circleCropTransform()).into(it) }
        }
    }

}







