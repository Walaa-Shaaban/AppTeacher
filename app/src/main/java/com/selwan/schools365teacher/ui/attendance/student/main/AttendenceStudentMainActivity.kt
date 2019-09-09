package com.selwan.schools365teacher.ui.attendance.student.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R

class AttendeneceStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendence_student)

        supportFragmentManager.beginTransaction().replace(R.id.frame_attendance_student,
            AttendanceStudentMainFragment()
        )
            .commitAllowingStateLoss()
    }
}
