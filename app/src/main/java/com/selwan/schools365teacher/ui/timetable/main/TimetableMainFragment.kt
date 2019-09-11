package com.selwan.schools365teacher.ui.timetable.main

import android.content.Intent
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
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.attendance.student.main.AttendanceStudentMainViewModel
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import com.selwan.schools365teacher.ui.timetable.tabs_day.TimetableTabsdayActivity
import kotlinx.android.synthetic.main.fragment_class_timetable.*
import kotlinx.android.synthetic.main.fragment_student_attendance.sp_class
import kotlinx.android.synthetic.main.fragment_student_attendance.sp_section

class TimetableMainFragment : Fragment() {

    var classes = ArrayList<String>()
    var sections = ArrayList<String>()

    companion object {
        fun newInstance() = StudentsDetailsFragment()
        var class_id: String? = "1"
        var section_id: String? = null

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_class_timetable, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getClasses()

        timetable_search.setOnClickListener {
            /*
            intent.putExtra("class_id", class_id)
            intent.putExtra("section_id", section_id)
            intent.putExtra("date", date)
             */
            val intent = Intent(this.activity, TimetableTabsdayActivity::class.java)
            intent.putExtra("class_id", "1")
            intent.putExtra("section_id", "1")
            startActivity(intent)
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



            sp_class.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    StudentsDetailsFragment.class_id = it.get(position).class_id
                    getSections()

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            })
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

            sp_section.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    StudentsDetailsFragment.section_id = it.get(position).id

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            })
        })

    }


    fun getViewModel(): AttendanceStudentMainViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceStudentMainViewModel() as T
            }

        })[AttendanceStudentMainViewModel::class.java]
    }


}
