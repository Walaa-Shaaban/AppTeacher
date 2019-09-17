package com.selwan.schools365teacher.ui.homework.add_new

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
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.homework.main.HomeworkMainActivity
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import kotlinx.android.synthetic.main.homework_add_new_fragment.*

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

        getClasses()

        getSubject()

        add_new_homework.setOnClickListener {
            getViewModel().addHomework(
                class_id = class_id!!, section_id = section_id!!, subject_id = "1",
                homework_date = "13-12-2019",
                submit_date = "14-12-2019",
                message = msg.text.toString()
            ).observe(this, Observer {
                Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this.context, HomeworkMainActivity::class.java))

            })
        }


    }


    fun getClasses() {
        getViewModel().getAllClasses.observe(this, Observer {
            for (class_name in it) {
                classes.add(class_name.`class`)
            }
            val adapter = ArrayAdapter<String>(
                this.activity!!, // Context
                android.R.layout.simple_spinner_item,
                classes
            )
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            sp_class.adapter = adapter



            sp_class.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    HomeworkAddNewFragment.class_id = it.get(position).class_id
                    getSections()

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })
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

    fun getSections() {
        getViewModel().getAllSections.observe(this, Observer {
            for (section_name in it) {
                sections.add(section_name.section)
            }
            val adapter = ArrayAdapter<String>(
                this.activity!!, // Context
                android.R.layout.simple_spinner_item,
                sections
            )
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            sp_section.adapter = adapter

            sp_section.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    HomeworkAddNewFragment.section_id = it.get(position).id


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
