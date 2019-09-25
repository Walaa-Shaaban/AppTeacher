package com.selwan.schools365teacher.ui.attendance.student.rec.AllStudentAttendance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R

class AttendanceStudentRecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_rec_student)

        supportFragmentManager.beginTransaction().replace(R.id.frame_attendance_student_rec,
            AttendanceStudentRecFragment()
        )
            .commitAllowingStateLoss()
    }
}
