package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main

import android.content.Context

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.selwan.schools365teacher.R

private val TAB_TITLES = arrayOf(

    R.string.tab_sunday,
    R.string.tab_monday,
    R.string.tab_thursday
)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): String? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }


}