package com.selwan.schools365teacher.ui.examination.tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.activity_exam_tabs.*

class ExamTabsActivity : AppCompatActivity() {

    private lateinit var viewModel: ExaminationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_tabs)

        viewModel = ViewModelProviders.of(this).get(ExaminationViewModel::class.java)
        viewModel.fetchAllExams.observe(this, Observer {
            val examPagerAdapter = ExamPagerAdapter(
                context = this, fm = supportFragmentManager,
                allExams = it
            )
            pager_exam.adapter = examPagerAdapter
            tabs_exam.setupWithViewPager(pager_exam)
        })

    }
}
