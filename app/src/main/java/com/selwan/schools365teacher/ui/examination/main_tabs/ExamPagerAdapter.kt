package com.selwan.schools365teacher.ui.examination.main_tabs


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule
import com.selwan.schools365teacher.ui.examination.ExaminationFragment

class ExamPagerAdapter(
    private var context: Context,
    fm: FragmentManager,
    var allExams: AllExamSchedule
) :
    FragmentPagerAdapter(fm) {

    lateinit var getAllExams: AllExamSchedule

    init {
        this.getAllExams = allExams
    }

    override fun getItem(position: Int): Fragment {

        return ExaminationFragment(getAllExams.exams.get(position).id)
    }

    override fun getCount(): Int {
        return getAllExams.exams.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return getAllExams.exams.get(position).name
    }
}