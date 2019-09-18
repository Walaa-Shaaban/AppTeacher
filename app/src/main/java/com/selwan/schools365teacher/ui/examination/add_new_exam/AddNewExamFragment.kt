package com.selwan.schools365teacher.ui.examination.add_new_exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew

class AddNewExamFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_new_exam_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var list = ArrayList<ExamScheduleAddNew>()
        list.add(ExamScheduleAddNew("10/10/2019", "12/1/2019", "20", "20", ""))

        getViewModel().AddNewExam.observe(this, Observer {

        })
    }

    fun getViewModel(): AddNewExamViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AddNewExamViewModel("1", "1", "1",) as T
            }

        })[AddNewExamViewModel::class.java]
    }


}
