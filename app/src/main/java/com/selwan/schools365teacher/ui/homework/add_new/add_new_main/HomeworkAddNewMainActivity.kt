package com.selwan.schools365teacher.ui.homework.add_new.add_new_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment

class HomeworkAddNewMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_add_new_main)


        supportFragmentManager.beginTransaction().replace(
            R.id.frame_homework_add_new_main,
            HomeworkAddNewMainFragment()
        )
            .commitAllowingStateLoss()

    }

}
