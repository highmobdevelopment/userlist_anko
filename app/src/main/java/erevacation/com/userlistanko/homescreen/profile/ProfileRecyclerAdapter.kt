package erevacation.com.userlistanko.homescreen.profile

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import erevacation.com.userlistanko.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.textResource

class ProfileRecyclerAdapter(val presenter: ProfileFragmentPresenter) : RecyclerView.Adapter<ProfileRecyclerAdapter.ProfileViewHolder>() {

    private val profileInfoList: ArrayList<String> = arrayListOf()

    private var listOfIcons: ArrayList<Int> = arrayListOf(
            R.drawable.email
            , R.drawable.home_address
            , R.drawable.home_phone
            , R.drawable.mobile_phone)

    private var listOfMenuField: ArrayList<Int> = arrayListOf(
            R.string.menu_field_email
            , R.string.menu_field_address
            , R.string.menu_field_home_phone
            , R.string.menu_field_mobile_phone)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder? {
        val itemView = AnkoViewHolderProfileUI().createView(AnkoContext.create(parent.context, parent))
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(profileInfoList[position], listOfIcons[position], listOfMenuField[position])
    }

    override fun getItemCount(): Int {
        return profileInfoList.size
    }

    fun updateUserDetails(data: ArrayList<String>) {
        this.profileInfoList.clear()
        this.profileInfoList.addAll(data)
        notifyDataSetChanged()
    }

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var cardName: TextView = itemView.find(R.id.item_name)
        private var profileDetails: TextView = itemView.find(R.id.item_details)
        private var itemIcon: ImageView = itemView.find(R.id.item_icon)

        fun bind(data: String, icon: Int, menuField: Int) {
            cardName.textResource = menuField
            profileDetails.text = data
            itemIcon.setImageResource(icon)

        }
    }
}