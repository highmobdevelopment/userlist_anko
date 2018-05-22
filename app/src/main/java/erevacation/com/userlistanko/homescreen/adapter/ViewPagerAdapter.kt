package erevacation.com.userlistanko.homescreen.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun removeAllfragments() {
        if (fragmentList != null) {
            for (fragment in fragmentList) {
                fragmentManager.beginTransaction().remove(fragment).commit()
            }
            fragmentList.clear()
            notifyDataSetChanged()
        }
    }

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}