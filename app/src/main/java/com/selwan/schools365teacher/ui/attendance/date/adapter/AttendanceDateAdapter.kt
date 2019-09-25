package com.selwan.schools365teacher.ui.attendance.date.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.AttendanceByDate
import com.selwan.schools365teacher.data.model.attendance.Attendencetypeslist
import com.selwan.schools365teacher.data.model.attendance.StudentArray
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.data.utils.AttendanceState

class AttendanceDateAdapter
    (context: Context, var studentAttendanceByDate: AttendanceByDate) :
    RecyclerView.Adapter<AttendanceDateAdapter.ViewHolder>() {

    var context: Context
    var getStudentAttendanceByDate: AttendanceByDate

    init {
        this.context = context
        this.getStudentAttendanceByDate = studentAttendanceByDate


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.attendance_date_adapter, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return getStudentAttendanceByDate.resultlist.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var studentDateAttendance = getStudentAttendanceByDate.resultlist.get(position)
        holder.studentName.text = studentDateAttendance.firstname
        holder.student_attendence_id.text =
            getAttendance(studentDateAttendance.attendenceTypeId.toString())


    }

    fun getAttendance(attendance_id: String): String {
        for (item in getStudentAttendanceByDate.attendencetypeslist) {
            if (item.id.equals(attendance_id)) {
                return item.type
            }
        }
        return ""
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var student_attendence_id: Button
        var studentName: TextView

        constructor(itemView: View) : super(itemView) {
            studentName = itemView.findViewById(R.id.student_name)
            student_attendence_id = itemView.findViewById(R.id.student_attendence_type)
        }

    }
}

