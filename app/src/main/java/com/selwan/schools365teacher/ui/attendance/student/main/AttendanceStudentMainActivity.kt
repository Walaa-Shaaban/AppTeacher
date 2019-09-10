package com.selwan.schools365teacher.ui.attendance.student.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanceStudentMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_student_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_attendance_student,
            AttendanceStudentMainFragment()
        )
            .commitAllowingStateLoss()
    }
}
