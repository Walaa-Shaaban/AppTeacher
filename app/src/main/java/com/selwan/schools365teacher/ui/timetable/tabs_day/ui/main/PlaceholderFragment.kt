package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main.adapter.TimetableTabsdayAdapter
import kotlinx.android.synthetic.main.timetable_tabsday_rec.*

class PlaceholderFragment(var tabText: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.timetable_tabsday_rec, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        if (NetworkUtils.isNetworkConnected(context!!)) {
            rec_timetable.layoutManager = LinearLayoutManager(this.context)
            getViewModel().getTimetable.observe(this, Observer {
                rec_timetable.adapter = TimetableTabsdayAdapter(it, this.context!!, tabText)
            })

        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()
        }
    }

    fun getViewModel(): TimetableTabsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TimetableTabsViewModel() as T
            }
        })[TimetableTabsViewModel::class.java]
    }

}