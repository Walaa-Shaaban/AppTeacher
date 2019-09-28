package com.selwan.schools365teacher.ui.notification.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.news.news_details.NewsDetailsFragment

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_notification,
            NotificationFragment()
        )
            .commitAllowingStateLoss()
    }
}
