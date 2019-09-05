package com.selwan.schools365teacher.ui.attendance.attendance_date

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class AttendanceDateFragment : Fragment() {

    companion object {
        fun newInstance() = AttendanceDateFragment()
    }

    private lateinit var viewModel: AttendanceDateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_date_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AttendanceDateViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
