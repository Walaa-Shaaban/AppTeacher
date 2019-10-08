package com.selwan.schools365teacher.ui.examination.tabs

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.activity_exam_tabs.*
import kotlinx.android.synthetic.main.timetable_tabsday_activity.*

class ExamTabsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_tabs)

        getViewModel().fetchAllExams.observe(this, Observer {
            val examPagerAdapter = ExamPagerAdapter(
                context = this, fm = supportFragmentManager,
                allExams = it

            )

            pager_exam.adapter = examPagerAdapter
            tabs_exam.setupWithViewPager(pager_exam)
        })

    }

    fun getViewModel(): ExaminationViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ExaminationViewModel(this@ExamTabsActivity) as T
            }

        })[ExaminationViewModel::class.java]
    }
}
