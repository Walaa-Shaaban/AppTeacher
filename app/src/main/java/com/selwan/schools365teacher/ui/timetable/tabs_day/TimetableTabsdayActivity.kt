package com.selwan.schools365teacher.ui.timetable.tabs_day

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main.SectionsPagerAdapter
import com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main.TimetableTabsViewModel
import kotlinx.android.synthetic.main.activity_timetable_tabsday.*


class TimetableTabsdayActivity : AppCompatActivity() {


    companion object {
        var tabText: String = "Sunday"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_tabsday)


        getViewModel().getTimetable.observe(this, Observer {
            var listOfDay = ArrayList<String>()
            listOfDay.add(it.getDaysnameList.Sunday)
            listOfDay.add(it.getDaysnameList.Monday)
            listOfDay.add(it.getDaysnameList.Tuesday)
            listOfDay.add(it.getDaysnameList.Wednesday)
            listOfDay.add(it.getDaysnameList.Thursday)
            listOfDay.add(it.getDaysnameList.Friday)
            listOfDay.add(it.getDaysnameList.Saturday)

            val sectionsPagerAdapter = SectionsPagerAdapter(
                this,
                supportFragmentManager,
                listOfDay,
                TimetableTabsdayActivity.tabText
            )
            view_pager.adapter = sectionsPagerAdapter

            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    TimetableTabsdayActivity.tabText = tab.text.toString()
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}

                override fun onTabReselected(tab: TabLayout.Tab) {}
            })


            tabs.setupWithViewPager(view_pager)


        })


    }

    fun getViewModel(): TimetableTabsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TimetableTabsViewModel() as T
            }

        })[TimetableTabsViewModel::class.java]
    }
}