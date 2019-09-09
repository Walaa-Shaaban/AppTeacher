package com.selwan.schools365teacher.ui.attendance.report.rec

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanceReportRecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_report)

        supportFragmentManager.beginTransaction().replace(R.id.frame_attendance_report,
            AttendanceReportRecFragment()
        )
            .commitAllowingStateLoss()
    }
}
