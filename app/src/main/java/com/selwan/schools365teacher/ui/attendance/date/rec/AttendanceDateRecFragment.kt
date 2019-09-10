package com.selwan.schools365teacher.ui.attendance.date.rec

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
import com.selwan.schools365teacher.ui.attendance.date.adapter.AttendanceDateAdapter
import kotlinx.android.synthetic.main.attendance_date_fragment.*

class AttendanceDateRecFragment(var class_id: String, var section_id: String, var date: String) :
    Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_date_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rec_date_attendance.layoutManager = LinearLayoutManager(this.context)

        getViewModel().getAllStudentAttendanceByDate.observe(this, Observer {
            rec_date_attendance.adapter = AttendanceDateAdapter(this.context!!, it)
        })


    }


    fun getViewModel(): AttendanceDateRecViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceDateRecViewModel(class_id, section_id, date) as T
            }
        })[AttendanceDateRecViewModel::class.java]
    }

}
