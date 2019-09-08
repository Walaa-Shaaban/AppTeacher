package com.selwan.schools365teacher.ui.attendance

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.attendance.attendance_date.AttendanceDateActivity
import com.selwan.schools365teacher.ui.attendance.attendance_student.student_attendence.AttendeneceStudentActivity
import kotlinx.android.synthetic.main.fragment_attendance.*

class AttendanceFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_attendance, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        student_attendance.setOnClickListener({
            startActivity(Intent(this.context, AttendeneceStudentActivity::class.java))
        })
        date_attendance.setOnClickListener({
            startActivity(Intent(this.context, AttendeneceStudentActivity::class.java))
        })
        report_attendance.setOnClickListener({

        })

    }

}
