package com.selwan.schools365teacher.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leena_attendance_by_date)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.frame, MainFragment()).commitAllowingStateLoss()
    }
}
