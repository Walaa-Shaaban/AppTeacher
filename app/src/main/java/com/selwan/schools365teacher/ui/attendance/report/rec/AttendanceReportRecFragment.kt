package com.selwan.schools365teacher.ui.attendance.report.rec

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
import kotlinx.android.synthetic.main.attendance_report_fragment.*

class AttendanceReportRecFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_report_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rec_attendance_report.layoutManager = LinearLayoutManager(this.context)
        getViewModel().getAllStudenAttendanceByReport.observe(this, Observer {
            rec_attendance_report.adapter = AttendanceReportRecAdapter(this.context!!, it)
        })

    }

    fun getViewModel(): AttendanceReportRecViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceReportRecViewModel() as T
            }

        })[AttendanceReportRecViewModel::class.java]
    }

}
