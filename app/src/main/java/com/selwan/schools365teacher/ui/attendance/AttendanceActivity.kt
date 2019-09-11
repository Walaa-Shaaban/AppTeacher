package com.selwan.schools365teacher.ui.attendance

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

       supportFragmentManager.beginTransaction().replace(R.id.frame_attendance_date, AttendanceFragment())
            .commitAllowingStateLoss()
    }
}
