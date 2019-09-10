package com.selwan.schools365teacher.ui.attendance.date.rec

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanceDateRecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_date)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_attendance_date,
            AttendanceDateRecFragment(
                intent.getStringExtra("class_id"),
                intent.getStringExtra("section_id"),
                intent.getStringExtra("date")
            )
        )
            .commitAllowingStateLoss()
    }
}
