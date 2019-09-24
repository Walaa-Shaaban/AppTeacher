package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class SectionsPagerAdapter(
    var context: Context,
    fm: FragmentManager,
    var listOfDay: ArrayList<String>,
    var tabText: String
) :
    FragmentPagerAdapter(fm) {




    override fun getItem(position: Int): Fragment {

        return PlaceholderFragment(tabText)
    }

    override fun getPageTitle(position: Int): String? {
        return listOfDay.get(position)
    }

    override fun getCount(): Int {

        return listOfDay.size
    }


}