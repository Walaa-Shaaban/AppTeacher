package com.selwan.schools365teacher.ui.attendance.date.main


import android.app.DatePickerDialog
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
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.attendance.date.rec.AttendanceDateRecActivity
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import kotlinx.android.synthetic.main.attendance_date_main_fragment.*
import kotlinx.android.synthetic.main.homework_add_new_fragment.*

import kotlin.collections.ArrayList


class AttendanceDateMainFragment : Fragment() {



    var classes = ArrayList<String>()
    var sections = ArrayList<String>()
    var getDate : String ?= null

    var year: Int? = null

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
            actv_Date_att.setOnClickListener {
                DatePickerDialog(this.context!!, R.style.DialogTheme,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        var month = monthOfYear
                        month = month + 1
                        var day = dayOfMonth
                        if (day < 10){
                            getDate = "0${day}/${month}/${year}"
                        }else{
                            getDate= "${day}/${month}/${year}"
                        }
                        actv_Date_att.text = getDate

                    }, 2019, 9, 6
                ).show()
            }
            acb_continue_att.setOnClickListener {

                val intent = Intent(this.activity, AttendanceDateRecActivity::class.java)
                intent.putExtra("class_id", class_id)
                intent.putExtra("section_id", section_id)
                intent.putExtra("date", getDate)
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
            acsp_select_class_att.adapter = adapter



            acsp_select_class_att.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
            acsp_select_section_att.adapter = adapter

            acsp_select_section_att.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
