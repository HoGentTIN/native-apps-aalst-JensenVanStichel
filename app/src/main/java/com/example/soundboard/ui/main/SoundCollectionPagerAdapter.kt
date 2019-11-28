package com.example.soundboard.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SoundCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    var categories = Array(6) {"All";"Ambient";"Atmosphere";"Monsters";"Mood";"Situation"}

    override fun getItem(position: Int): Fragment {
        val fragment = SoundFragment()
        fragment.arguments = Bundle().apply {
            putString("", categories[position])
        }
        return fragment
    }

    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return categories[position]
    }
}