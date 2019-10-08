package com.selwan.schools365teacher.ui.attendance.report.main

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
import com.selwan.schools365teacher.ui.attendance.report.rec.AttendanceReportRecActivity
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import kotlinx.android.synthetic.main.attendance_report_main_fragment.*
class AttendanceReportMainFragment : Fragment() {


    var classes = ArrayList<String>()
    var sections = ArrayList<String>()
    var listYears = ArrayList<Int>()
    var listMonth = ArrayList<String>()

    companion object {
        fun newInstance() = StudentsDetailsFragment()
        var class_id: String? = null
        var section_id: String? = null
        var year: String? = null
        var month: String? = null

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_report_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            getClasses()
            getYears()
            getMonth()
            att_acb_continue.setOnClickListener {

                val intent = Intent(this.context, AttendanceReportRecActivity::class.java)
                intent.putExtra("class_id", class_id)
                intent.putExtra("section_id", section_id)
                intent.putExtra("year", year)
                intent.putExtra("month", month)
                startActivity(intent)
            }
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()
        }


    }

    fun getMonth() {

        listMonth.add("January")
        listMonth.add("February")
        listMonth.add("March")
        listMonth.add("April")
        listMonth.add("May")
        listMonth.add("June")
        listMonth.add("July")
        listMonth.add("August")
        listMonth.add("September")
        listMonth.add("October")
        listMonth.add("November")
        listMonth.add("December ")

        val adapter = ArrayAdapter<String>(
            this.activity!!, // Context
            android.R.layout.simple_spinner_item,
            listMonth
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        acsp_select_month.adapter = adapter
        acsp_select_month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View,
                position: Int,
                l: Long
            ) {
                adapterView.getItemAtPosition(position)
                month = listMonth.get(position)


            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {
                return
            }
        }


    }

    fun getYears() {
        for (item in 2020 downTo 1990) {
            listYears.add(item)
        }

        val adapter = ArrayAdapter<Int>(
            this.activity!!, // Context
            android.R.layout.simple_spinner_item,
            listYears
        )
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        acsp_select_year.adapter = adapter
        acsp_select_year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>,
                view: View,
                position: Int,
                l: Long
            ) {
                adapterView.getItemAtPosition(position)
                year = listYears.get(position).toString()


            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {
                return
            }
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
            att_acsp_select_class.adapter = adapter



            att_acsp_select_class.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

    fun getSections() {
        getViewModel().getAllSection.observe(this, Observer {
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
            att_acsp_select_section.adapter = adapter

            att_acsp_select_section.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

    fun getViewModel(): AttendanceReportMainViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceReportMainViewModel() as T
            }

        })[AttendanceReportMainViewModel::class.java]
    }

}
