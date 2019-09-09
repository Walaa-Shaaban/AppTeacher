package com.selwan.schools365teacher.ui.attendance.report.report_info.overview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AttendanaceReportInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendanace_report_info)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_report_info_overview,
            AttendanceReportInfoFragment(intent.getStringExtra("student_id"))
        )
            .commitAllowingStateLoss()
    }
}
