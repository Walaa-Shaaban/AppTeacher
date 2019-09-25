package com.selwan.schools365teacher.ui.homework.add_new.add_new_continue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class HomeworkAddNewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework_add_new)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_homework_add_new,
            HomeworkAddNewFragment()
        )
            .commitAllowingStateLoss()
    }
}
