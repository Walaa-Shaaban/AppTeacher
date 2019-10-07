package com.selwan.schools365teacher.ui.homework.add_new.add_new_continue

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
import com.selwan.schools365teacher.ui.homework.AllHomework.AllHomeworkActivity
import com.selwan.schools365teacher.ui.homework.add_new.add_new_main.HomeworkAddNewMainFragment
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment

import kotlinx.android.synthetic.main.homework_add_new_fragment.*
import android.text.TextUtils
import java.util.*
import kotlin.collections.ArrayList
import android.app.DatePickerDialog



class HomeworkAddNewFragment : Fragment() {



    var date_homework: String ?= null
    var date_submit : String ?= null

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



        acb_select_date.setOnClickListener {

            DatePickerDialog(this.context!!, com.selwan.schools365teacher.R.style.DialogTheme,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var month = monthOfYear
                    month = month + 1

                    acb_select_date.text = "$year-$month-$dayOfMonth"
                }, 2019, 9, 6
            ).show()


        }


        acb_select_submit_date.setOnClickListener {
            DatePickerDialog(this.context!!, com.selwan.schools365teacher.R.style.DialogTheme,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var month = monthOfYear
                    month = month + 1

                    acb_select_submit_date.text = "$year-$month-$dayOfMonth"
                }, 2015, 2, 26
            ).show()

        }



        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            getSubject()

            acb_send_message.setOnClickListener {



                if (TextUtils.isEmpty(subject_id) || TextUtils.isEmpty(
                        acb_select_date.text
                    ) || TextUtils.isEmpty(acb_select_submit_date.text) || TextUtils.isEmpty(acet_message.text)
                ) {

                    val snackbar =
                        Snackbar.make(view!!, "There are empty fields ...", Snackbar.LENGTH_LONG)
                    val sbView = snackbar.view
                    sbView.setBackgroundResource(R.color.redHighDelete)
                    snackbar.show()

                }else{
                    getViewModel().addHomework(
                        class_id = HomeworkAddNewMainFragment.class_id!!,
                        section_id = HomeworkAddNewMainFragment.section_id!!,
                        subject_id = HomeworkAddNewFragment.subject_id!!,
                        homework_date = date_homework.toString(),
                        submit_date = date_submit.toString(),
                        message = acet_message.text.toString()
                    ).observe(this, Observer {
                        val snackbar =
                            Snackbar.make(view!!, it.message, Snackbar.LENGTH_LONG)
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()

                        startActivity(Intent(this.context, AllHomeworkActivity::class.java))

                    })


                }

            }
        }else {
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
            acsp_select_roles.adapter = adapter



            acsp_select_roles.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
