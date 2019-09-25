package com.selwan.schools365teacher.ui.news.news_main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_news,
            NewsFragment()
        )
            .commitAllowingStateLoss()
    }
}
