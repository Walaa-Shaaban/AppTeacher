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
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew
import kotlinx.android.synthetic.main.add_new_exam_fragment.*

class AddNewExamFragment : Fragment() {

    var list = ArrayList<ExamScheduleAddNew>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_new_exam_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnAddExam.setOnClickListener {
            list.add(
                ExamScheduleAddNew(
                    "10/10/2019",
                    "17/10/2019",
                    "20",
                    "20",
                    "12",
                    "12/10/2019",
                    1
                )
            )

            getViewModel().AddNewExam.observe(this, Observer {
                Snackbar.make(view!!, it.msg, Snackbar.LENGTH_LONG)
                    .show()
            })
        }


    }

    fun getViewModel(): AddNewExamViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AddNewExamViewModel("1", "1", "1", list) as T
            }

        })[AddNewExamViewModel::class.java]
    }


}
