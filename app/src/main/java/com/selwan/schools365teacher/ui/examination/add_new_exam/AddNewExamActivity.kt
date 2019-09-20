package com.selwan.schools365teacher.ui.examination.add_new_exam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selwan.schools365teacher.R

class AddNewExamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_exam)

        supportFragmentManager.beginTransaction().replace(
            R.id.frame_add_new_exam,
            AddNewExamFragment(intent.getStringExtra("exam_id"))
        )
            .commitAllowingStateLoss()


    }
}
