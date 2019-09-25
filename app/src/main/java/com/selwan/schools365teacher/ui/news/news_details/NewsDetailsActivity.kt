package com.selwan.schools365teacher.ui.news.news_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.news.news_main.NewsFragment

class NewsDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        supportFragmentManager.beginTransaction().replace(
            R.id.frame_news_details,
            NewsDetailsFragment(
                title = intent.getStringExtra("title"),
                desc = intent.getStringExtra("desc"),
                date = intent.getStringExtra("date"),
                img_url = intent.getStringExtra("image")
            )
        )
            .commitAllowingStateLoss()
    }
}
