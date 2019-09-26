package com.selwan.schools365teacher.ui.attendance.date.main

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.attendance.date.rec.AttendanceDateRecActivity
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import android.widget.Toast
import com.shagi.materialdatepicker.date.DatePickerFragmentDialog
import kotlinx.android.synthetic.main.attendance_date_main_fragment.*
import kotlinx.android.synthetic.main.attendance_student_main_fragment.attendance_search
import kotlinx.android.synthetic.main.students_details_fragment.*
import kotlinx.android.synthetic.main.students_details_fragment.sp_class
import kotlinx.android.synthetic.main.students_details_fragment.sp_section

import kotlin.collections.ArrayList


class AttendanceDateMainFragment : Fragment() {



    var classes = ArrayList<String>()
    var sections = ArrayList<String>()

    var year: Int? = null
    var monthOfYear: Int? = null
    var dayOfMonth: String? = null

    companion object {
        fun newInstance() = StudentsDetailsFragment()
        var class_id: String? = null
        var section_id: String? = null
        var date : String? = null

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            com.selwan.schools365teacher.R.layout.attendance_date_main_fragment,
            container,
            false
        )
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        if (NetworkUtils.isNetworkConnected(this.context!!)) {


            getClasses()
            attendance_date.setOnClickListener {
                val dialog =
                    DatePickerFragmentDialog.newInstance({ view, year, monthOfYear, dayOfMonth ->
                        this.year = year
                        this.monthOfYear = monthOfYear + 1
                        this.dayOfMonth = dayOfMonth.toString()
                        if (dayOfMonth < 10) {
                            this.dayOfMonth = "0${this.dayOfMonth}"
                        }
                        attendance_date.text = "${this.dayOfMonth}/${this.monthOfYear}/${this.year}"
                    }, 2020, 12, 4)
                dialog.show(fragmentManager!!, "tag")
            }
            attendance_search.setOnClickListener {

                val intent = Intent(this.activity, AttendanceDateRecActivity::class.java)
                intent.putExtra("class_id", class_id)
                intent.putExtra("section_id", section_id)
                intent.putExtra("date", "${this.dayOfMonth}/${this.monthOfYear}/${this.year}")
                startActivity(intent)
            }
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(com.selwan.schools365teacher.R.color.redHighDelete)
            snackbar.show()
        }

    }


    fun getClasses(){
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
                    class_id = it.get(position).class_id
                    getSections()

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })
    }

    fun getSections(){
        getViewModel().getAllSections.observe(this, Observer {
            sections.clear()
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
                    section_id = it.get(position).id

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })

    }



    fun getViewModel(): AttendanceDateMainViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceDateMainViewModel() as T
            }

        })[AttendanceDateMainViewModel::class.java]
    }

}
