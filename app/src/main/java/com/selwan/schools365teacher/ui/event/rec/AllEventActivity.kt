package com.selwan.schools365teacher.ui.event.rec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R

class AllEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_event_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.frame_all_event,
                    AllEventFragment(intent.getStringExtra("start_date"))
                )
                .commitNow()
        }
    }

}
