package com.example.soundboard.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter.POSITION_NONE
import java.nio.file.Files.size
import androidx.fragment.app.FragmentStatePagerAdapter


class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFrag(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }

    override fun getItemPosition(`object`: Any): Int {
        // Causes adapter to reload all Fragments when
        // notifyDataSetChanged is called
        notifyDataSetChanged()
        return POSITION_NONE
    }
}