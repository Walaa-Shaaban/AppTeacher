package com.selwan.schools365teacher.ui.attendance.student.rec.change_attendance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R

class AttendanceChangeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_change)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_attendance_change,
            AttendanceChangeFragment(
                intent.getStringExtra("attendence_id"),
                intent.getStringExtra("student_session")
            )
        )
            .commitAllowingStateLoss()
    }
}
