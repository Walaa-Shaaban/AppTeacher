package com.selwan.schools365teacher.ui.attendance.attendance_report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class AttendanceReportFragment : Fragment() {

    companion object {
        fun newInstance() = AttendanceReportFragment()
    }

    private lateinit var viewModel: AttendanceReportViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_report_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AttendanceReportViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
