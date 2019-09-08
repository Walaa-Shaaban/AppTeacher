package com.selwan.schools365teacher.ui.student_details

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.selwan.schools365teacher.ui.student_details.recyclerview_student_details.RecyclerStudentDetailsActivity
import kotlinx.android.synthetic.main.students_details_fragment.*


class StudentsDetailsFragment : Fragment() {

    var classes = ArrayList<String>()
    var sections = ArrayList<String>()

    companion object {
        fun newInstance() = StudentsDetailsFragment()
        var class_id: String? = null
        var section_id: String? = null

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.students_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        getClasses()


        search.setOnClickListener {
            val intent = Intent(this.activity, RecyclerStudentDetailsActivity::class.java)
            startActivity(intent)
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



            sp_class.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
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
            })
        })
    }

    fun getSections(){
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
                    section_id = it.get(position).id

                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            })
        })

    }


    //Send args using factory
    fun getViewModel(): StudentsDetailsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return StudentsDetailsViewModel() as T
            }

        })[StudentsDetailsViewModel::class.java]
    }

}
