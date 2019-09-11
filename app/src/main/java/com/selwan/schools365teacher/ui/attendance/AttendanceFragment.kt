package com.selwan.schools365teacher.ui.attendance

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.attendance.date.main.AttendeneceDateMainActivity
import com.selwan.schools365teacher.ui.attendance.report.main.AttendanceReportMainActivity
import com.selwan.schools365teacher.ui.attendance.student.main.AttendanceStudentMainActivity
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
            startActivity(Intent(this.context, AttendanceStudentMainActivity::class.java))
        })
        date_attendance.setOnClickListener({
            startActivity(Intent(this.context, AttendeneceDateMainActivity::class.java))
        })
        report_attendance.setOnClickListener({
            startActivity(Intent(this.context, AttendanceReportMainActivity::class.java))
        })

    }
}
