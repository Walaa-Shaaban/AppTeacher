package com.selwan.schools365teacher.ui.attendance.attendance_report.recyclerview.repor_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class ReportInfoFragment : Fragment() {

    companion object {
        fun newInstance() = ReportInfoFragment()
    }

    private lateinit var viewModel: ReportInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.report_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReportInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
