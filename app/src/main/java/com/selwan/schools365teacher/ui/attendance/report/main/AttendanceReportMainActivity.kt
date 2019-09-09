package com.selwan.schools365teacher.ui.attendance.report.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanceReportMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_report_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_attendance_report_main, AttendanceReportMainFragment())
            .commitAllowingStateLoss()
    }
}
