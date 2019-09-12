package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.selwan.schools365teacher.R


class SectionsPagerAdapter(private var context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {


    private val TAB_TITLES = arrayOf(
        R.string.tab_sunday, R.string.tab_saturday

    )



    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment()
    }

    override fun getPageTitle(position: Int): String? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }


}