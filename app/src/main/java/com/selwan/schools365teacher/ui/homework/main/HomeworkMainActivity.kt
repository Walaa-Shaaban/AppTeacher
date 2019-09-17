package com.selwan.schools365teacher.ui.homework.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class HomeworkMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeworkmain)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(
            R.id.frame_homework_main,
            HomeworkMainFragment()
        )
            .commitAllowingStateLoss()
    }
}
