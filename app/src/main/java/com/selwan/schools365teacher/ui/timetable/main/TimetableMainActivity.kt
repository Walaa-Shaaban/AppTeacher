package com.selwan.schools365teacher.ui.timetable.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class TimetableMainActivity : AppCompatActivity() {

    companion object {
        var context = this
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timetable_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_timetable_main, TimetableMainFragment())
            .commitAllowingStateLoss()
    }
}
