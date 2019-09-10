package com.selwan.schools365teacher.ui.attendance.date.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendeneceDateMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendence_student)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_attendance_student_date,
            AttendanceDateMainFragment()
        )
            .commitAllowingStateLoss()
    }
}
