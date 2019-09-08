package com.selwan.schools365teacher.ui.attendance.attendance_student.recycler

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.attendance.attendance_student.adapter.AttendenceStudentAdapter
import kotlinx.android.synthetic.main.activity_recycler_student_details.*
import kotlinx.android.synthetic.main.attendance_student_rec_fragment.*

class AttendanceStudentRecFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_student_rec_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        rec_attendence.layoutManager = LinearLayoutManager(this.context)

        getViewModel().getStudentAttendance.observe(this, Observer {
            rec_attendence.adapter = AttendenceStudentAdapter(this.context!!, it)
        })


    }


    fun getViewModel(): AttendanceStudentRecViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceStudentRecViewModel() as T
            }

        })[AttendanceStudentRecViewModel::class.java]
    }

}
