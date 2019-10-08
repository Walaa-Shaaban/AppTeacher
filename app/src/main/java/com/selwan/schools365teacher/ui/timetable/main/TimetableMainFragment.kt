package com.selwan.schools365teacher.ui.timetable.main

import android.content.Context
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
import com.selwan.schools365teacher.ui.timetable.tabs_day.TimetableTabsdayActivity
import kotlinx.android.synthetic.main.timetable_fragment.*


class TimetableMainFragment : Fragment() {

    var classes = ArrayList<String>()
    var sections = ArrayList<String>()

    companion object {
        var class_id: String? = null
        var section_id: String? = null
        var context: Context? = null
        var view: View? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.timetable_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        TimetableMainFragment.context = this.context
        TimetableMainFragment.view = view!!

        if (NetworkUtils.isNetworkConnected(TimetableMainFragment.context!!)) {
            getClasses()
            att_acb_continue.setOnClickListener {
                val intent = Intent(this.activity, TimetableTabsdayActivity::class.java)
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


    fun getClasses() {
        getViewModel().getAllClasses!!.observe(this, Observer {
            for (class_name in it) {
                classes.add(class_name.`class`)
            }
            val adapter = ArrayAdapter<String>(
                this.activity!!, // Context
                android.R.layout.simple_spinner_item,
                classes
            )
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            acsp_select_class.adapter = adapter



            acsp_select_class.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    TimetableMainFragment.class_id = it.get(position).class_id
                    if (TimetableMainFragment.class_id != null) {
                        getSections()
                    }


                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })
    }

    fun getSections() {
        getViewModel().getAllSections!!.observe(this, Observer {

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
                    TimetableMainFragment.section_id = it.get(position).id

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })

    }


    fun getViewModel(): TimetableMainViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TimetableMainViewModel() as T
            }

        })[TimetableMainViewModel::class.java]
    }


}
