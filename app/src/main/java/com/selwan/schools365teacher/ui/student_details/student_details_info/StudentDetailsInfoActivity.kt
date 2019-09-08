package com.selwan.schools365teacher.ui.student_details.student_details_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment

class StudentDetailsInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details_info)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_detail_info, StudentDetailsInfoFragment(intent.getStringExtra("student_id")))
            .commitAllowingStateLoss()
    }
}
