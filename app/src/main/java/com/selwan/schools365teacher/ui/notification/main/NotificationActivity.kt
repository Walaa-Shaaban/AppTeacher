package com.selwan.schools365teacher.ui.notification.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R

class NotificationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_activity)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_notification,
            NotificationFragment()
        )
            .commitAllowingStateLoss()
    }

}
