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
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main.adapter.TimetableTabsdayAdapter
import kotlinx.android.synthetic.main.fragment_timetable_tabsday.*

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: TimetableTabsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(TimetableTabsViewModel::class.java).apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timetable_tabsday, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rec_timetable.layoutManager = LinearLayoutManager(this.context)
        getViewModel().getTimetable.observe(this, Observer {
            rec_timetable.adapter = TimetableTabsdayAdapter(it, this.context!!)
        })
    }

    fun getViewModel(): TimetableTabsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TimetableTabsViewModel() as T
            }
        })[TimetableTabsViewModel::class.java]
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}