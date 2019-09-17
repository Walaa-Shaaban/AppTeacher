package com.selwan.schools365teacher.ui.attendance.student.rec.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.data.model.attendance.StudentSession
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.attendance.student.main.AttendanceStudentMainFragment
import com.selwan.schools365teacher.ui.attendance.student.rec.adapter.AttendenceStudentRecAdapter.ViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.*


class AttendenceStudentRecAdapter(context: Context, studentAttends: StudentAttendance) :
    RecyclerView.Adapter<ViewHolder>() {

    var context: Context
    var studentAttendence: StudentAttendance
    var compositeDisposable: CompositeDisposable
    var studentSession: List<StudentSession> = ArrayList()

    init {
        this.context = context
        this.studentAttendence = studentAttends
        this.compositeDisposable = CompositeDisposable()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.attendence_adapter, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return studentAttendence.resultlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var radioGroup: RadioGroup
        var save: Button
        var attendanceType_id: Int? = null
        holder.studentName.text = studentAttendence.resultlist.get(position).firstname
        holder.student_attendence_id.text =
            studentAttendence.resultlist.get(position).attendenceId.toString()
        holder.student_attendence_id.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(context)
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val alertLayout = inflater.inflate(R.layout.dialog_student_attendance, null)
            dialogBuilder.setView(alertLayout)
            radioGroup = alertLayout.findViewById(R.id.groupradio)
            save = alertLayout.findViewById(R.id.save)
            radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    R.id.radio_present -> attendanceType_id = 1
                    R.id.radio_absent -> attendanceType_id = 4
                    R.id.radio_halfday -> attendanceType_id = 6
                    R.id.radio_late -> attendanceType_id = 3
                    R.id.radio_holoday -> attendanceType_id = 5
                }
            })

            save.setOnClickListener {
                compositeDisposable.add(
                    ApiUtils.apiService.attendanceSave(
                        AttendanceStudentMainFragment.class_id!!,
                        AttendanceStudentMainFragment.section_id!!,
                        "28-12-1998",
                        false,
                        arrayListOf(
                            StudentSession(
                                attendence_type_id = attendanceType_id!!,
                                attendence_id = 2,
                                remark = "1111",
                                attendences_other_notes = listOf(1),
                                student_session_id = 86
                            )
                        )
                    )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            Consumer {
                                Toast.makeText(context, it.msg, Toast.LENGTH_SHORT).show()
                            })
                )


            }
            val alertDialog = dialogBuilder.create()
            alertDialog.show()


        }
    }



    class ViewHolder : RecyclerView.ViewHolder {
        var student_attendence_id: TextView
        var studentName: TextView

        constructor(itemView: View) : super(itemView) {
            studentName = itemView.findViewById(R.id.student_name)
            student_attendence_id = itemView.findViewById(R.id.student_attendence_type)
        }

    }


}
