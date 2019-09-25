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
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import kotlinx.android.synthetic.main.attendance_report_fragment.*

class AttendanceReportRecFragment(
    var class_id: String,
    var section_id: String,
    var year: String,
    var month: String
) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_report_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            rec_attendance_report.layoutManager = LinearLayoutManager(this.context)
            getViewModel().getAllStudenAttendanceByReport.observe(this, Observer {
                rec_attendance_report.adapter = AttendanceReportRecAdapter(this.context!!, it)
            })
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()
        }


    }

    fun getViewModel(): AttendanceReportRecViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceReportRecViewModel(
                    class_id = class_id,
                    section_id = section_id,
                    year = year,
                    month = month
                ) as T
            }

        })[AttendanceReportRecViewModel::class.java]
    }

}
