package com.selwan.schools365teacher.ui.attendance.date

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanceDateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_date)

        supportFragmentManager.beginTransaction().replace(R.id.frame_attendance_date, AttendanceDateFragment())
            .commitAllowingStateLoss()
    }
}
