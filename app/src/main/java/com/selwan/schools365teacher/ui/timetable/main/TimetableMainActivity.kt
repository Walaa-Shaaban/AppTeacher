package com.selwan.schools365teacher.ui.timetable.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class TimetableMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_timetable_main, TimetableMainFragment())
            .commitAllowingStateLoss()
    }
}
