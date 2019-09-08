package com.selwan.schools365teacher.ui.student_details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_detail, StudentsDetailsFragment())
            .commitAllowingStateLoss()

    }
}
