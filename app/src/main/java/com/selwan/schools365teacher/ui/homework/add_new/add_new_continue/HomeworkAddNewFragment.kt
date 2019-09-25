package com.selwan.schools365teacher.ui.homework.add_new.add_new_continue

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.homework.AllHomework.AllHomeworkActivity
import com.selwan.schools365teacher.ui.homework.add_new.add_new_main.HomeworkAddNewMainFragment
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import kotlinx.android.synthetic.main.add_new_exam_fragment.*
import kotlinx.android.synthetic.main.homework_add_new_fragment.*
import kotlinx.android.synthetic.main.homework_add_new_fragment.sp_subject

class HomeworkAddNewFragment : Fragment() {

    var classes = ArrayList<String>()
    var sections = ArrayList<String>()
    var subjects = ArrayList<String>()

    companion object {
        fun newInstance() = StudentsDetailsFragment()
        var class_id: String? = null
        var section_id: String? = null
        var subject_id: String? = null

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.homework_add_new_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            getSubject()

            add_new_homework.setOnClickListener {
                getViewModel().addHomework(
                    class_id = HomeworkAddNewMainFragment.class_id!!,
                    section_id = HomeworkAddNewMainFragment.section_id!!,
                    subject_id = HomeworkAddNewFragment.subject_id!!,
                    homework_date = homework_date.text.toString(),
                    submit_date = submit_date.text.toString(),
                    message = msg.text.toString()
                ).observe(this, Observer {
                    Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this.context, AllHomeworkActivity::class.java))

                })
            }
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()

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
                    HomeworkAddNewFragment.subject_id = it.get(position).name


                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })

    }

    fun getViewModel(): HomeworkAddNewViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeworkAddNewViewModel() as T
            }

        })[HomeworkAddNewViewModel::class.java]
    }


}
