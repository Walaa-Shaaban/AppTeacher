package com.selwan.schools365teacher.ui.attendance.report.report_info.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.attendance_report_info_fragment.*

class AttendanceReportInfoFragment(var student_id: String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_report_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getViewModel().studentReportInfo.observe(this, Observer {

            var str: StringBuilder = java.lang.StringBuilder()
            for (monthAttendance in it.monthAttendance) {


                var value = monthAttendance.get(student_id)


                if (monthAttendance.get(student_id)!!.equals(student_id)) {
                    str.append("\n absent")
                    str.append(monthAttendance.getValue(student_id).absent)
                    str.append("\n Half day")
                    str.append(monthAttendance.getValue(student_id).half_day)
                    str.append("\n late")
                    str.append(monthAttendance.getValue(student_id).late)
                    str.append("\n Present")
                    str.append(monthAttendance.getValue(student_id).present)
                }
            }
            txt_report_info.text = str
        })

    }

    fun getViewModel(): AttendanceReportInfoViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceReportInfoViewModel() as T
            }
        })[AttendanceReportInfoViewModel::class.java]
    }

}
