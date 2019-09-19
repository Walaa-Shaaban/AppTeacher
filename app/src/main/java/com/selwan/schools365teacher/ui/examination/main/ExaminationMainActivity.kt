package com.selwan.schools365teacher.ui.examination.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class ExaminationMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examination_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_exam_main,
            ExaminationMainFragment()
        )
            .commitAllowingStateLoss()

    }
}
