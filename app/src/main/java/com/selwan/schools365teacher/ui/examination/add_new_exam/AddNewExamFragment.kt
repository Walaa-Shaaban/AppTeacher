package com.selwan.schools365teacher.ui.examination.add_new_exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import com.selwan.schools365teacher.ui.homework.add_new.HomeworkAddNewFragment
import kotlinx.android.synthetic.main.add_new_exam_fragment.*
import kotlinx.android.synthetic.main.add_new_exam_fragment.sp_subject
import kotlinx.android.synthetic.main.homework_add_new_fragment.*

class AddNewExamFragment(var exam_id: String) : Fragment() {

    var list = ArrayList<ExamScheduleAddNew>()
    var subjects = ArrayList<String>()
    lateinit var subjet_id: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_new_exam_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getSubject()

        btnAddExam.setOnClickListener {
            list.add(
                ExamScheduleAddNew(
                    date_of_exam = et_date.text.toString(),
                    end_from = from.text.toString(),
                    full_marks = full_mark.text.toString(),
                    passing_marks = passing_mark.text.toString(),
                    room_no = room_no.text.toString(),
                    start_to = to.text.toString(),
                    teacher_subject_id = 1

                )
            )

            getViewModel().addNewExamByTeacher().observe(this, Observer {
                Snackbar.make(view!!, it.msg, Snackbar.LENGTH_LONG)
                    .show()
            })
        }


    }

    fun getSubject() {
        getViewModel().getSubject.observe(this, Observer {
            for (subject_name in it) {
                subjects.add(subject_name.name)
            }
            val adapter = ArrayAdapter<String>(
                this.activity!!, // Context
                android.R.layout.simple_spinner_item,
                subjects
            )
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            sp_subject.adapter = adapter



            sp_subject.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    subjet_id = it.get(position).name


                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })
    }

    fun getViewModel(): AddNewExamViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AddNewExamViewModel(
                    ExaminationMainFragment.class_id!!,
                    ExaminationMainFragment.section_id!!,
                    exam_id = exam_id,
                    listExam = list
                ) as T
            }

        })[AddNewExamViewModel::class.java]
    }


}
