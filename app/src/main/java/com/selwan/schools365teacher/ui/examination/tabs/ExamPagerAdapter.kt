package com.selwan.schools365teacher.ui.examination.tabs


import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule

class ExamPagerAdapter(
    private var context: Context,
    fm: FragmentManager,
    var allExams: AllExamSchedule
) :
    FragmentPagerAdapter(fm) {

    var getAllExams: AllExamSchedule

    init {
        this.getAllExams = allExams
    }

    override fun getItem(position: Int): Fragment {

        return ExaminationFragment(
            getAllExams.exams.get(
                position
            ).id
        )
    }

    override fun getCount(): Int {
        return getAllExams.exams.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        Log.e("##", getAllExams.exams.get(position).name)
        return getAllExams.exams.get(position).name
    }
}