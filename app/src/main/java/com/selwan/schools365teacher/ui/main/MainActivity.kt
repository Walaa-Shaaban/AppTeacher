package com.selwan.schools365teacher.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_activity, MainFragment()).commitAllowingStateLoss()
    }
}
