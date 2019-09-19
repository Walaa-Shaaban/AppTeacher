package com.selwan.schools365teacher.ui.examination.tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class ExaminationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examination)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_examination,
            ExaminationFragment("")
        )
            .commitAllowingStateLoss()



    }

}
