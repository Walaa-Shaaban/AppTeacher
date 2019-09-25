package com.selwan.schools365teacher.ui.attendance.student.rec.change_attendance

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.Attendencetypeslist
import com.selwan.schools365teacher.data.model.attendance.StudentSession
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.attendance.student.main.AttendanceStudentMainFragment
import com.selwan.schools365teacher.ui.attendance.student.rec.AllStudentAttendance.AttendanceStudentRecViewModel
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import kotlinx.android.synthetic.main.attendance_change_fragment.*
import kotlinx.android.synthetic.main.students_details_fragment.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AttendanceChangeFragment(var attendance_id: String, var student_session: String) :
    Fragment() {

    var isHoliday = false
    var attendanceTypeList = ArrayList<String>()
    var attendance_other_note = ArrayList<String>()
    var list_student_session = ArrayList<StudentSession>()

    companion object {
        var attendance_type: String? = null
        var attendance_type_id: String? = null
        var attendance_note_id: String? = null
        var attendance_other_note_type: String? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_change_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            getAllAttendanceType()
            getAllOtherNote()
            val stu_session = StudentSession(
                attendence_id = attendance_id.toInt(),
                remark = note.text.toString(),
                attendence_type_id = attendance_type_id!!.toInt(),
                attendences_other_notes = attendance_note_id!!.toInt(),
                student_session_id = student_session.toInt()
            )
            list_student_session.add(stu_session)
            change_attendance.setOnClickListener {
                getViewModel().saveChangeAttendance.observe(this, androidx.lifecycle.Observer {
                    Toast.makeText(this.context, it.msg, Toast.LENGTH_SHORT).show()
                })
            }
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()
        }

//

    }


    fun getViewModel(): AttendanceChangeViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AttendanceChangeViewModel(
                    class_id = AttendanceStudentMainFragment.class_id!!,
                    section_id = AttendanceStudentMainFragment.section_id!!,
                    date = getToday(),
                    isHoliday = isHoliday,
                    studentSession = list_student_session

                ) as T
            }

        })[AttendanceChangeViewModel::class.java]
    }

    fun getAllOtherNote() {
        getViewModel().getAttendanceType.observe(this, androidx.lifecycle.Observer {
            for (item in it.otherNotes) {
                attendance_other_note.add(item.type)
            }
            val adapter = ArrayAdapter<String>(
                this.activity!!, // Context
                android.R.layout.simple_spinner_item,
                attendance_other_note
            )

            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            sp_other_note.adapter = adapter
            sp_other_note.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>,
                    view: View,
                    position: Int,
                    l: Long
                ) {
                    adapterView.getItemAtPosition(position)
                    attendance_other_note_type = it.otherNotes.get(position).type
                    attendance_note_id = it.otherNotes.get(position).id


                }

                override fun onNothingSelected(adapterView: AdapterView<*>) {
                    return
                }
            }
        })

    }

    fun getAllAttendanceType() {
        getViewModel().getAttendanceType.observe(this, androidx.lifecycle.Observer {
            for (item in it.attendencetypeslist) {
                attendanceTypeList.add(item.type)
            }
            val adapter = ArrayAdapter<String>(
                this.activity!!, // Context
                android.R.layout.simple_spinner_item,
                attendanceTypeList
            )

            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            sp_attendance_type.adapter = adapter
            sp_attendance_type.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        adapterView: AdapterView<*>,
                        view: View,
                        position: Int,
                        l: Long
                    ) {
                        adapterView.getItemAtPosition(position)
                        attendance_type = it.attendencetypeslist.get(position).type
                        attendance_type_id = it.attendencetypeslist.get(position).id


                    }

                    override fun onNothingSelected(adapterView: AdapterView<*>) {
                        return
                    }
                }
        })
    }

    fun getToday(): String {
        return SimpleDateFormat("dd/M/yyyy").format(Date())

    }

}
