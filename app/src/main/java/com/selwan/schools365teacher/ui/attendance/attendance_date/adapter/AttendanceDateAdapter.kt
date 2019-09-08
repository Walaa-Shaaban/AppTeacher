package com.selwan.schools365teacher.ui.attendance.attendance_date.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.AttendanceByDate

class AttendanceDateAdapter
    (context : Context, listStudentAttendsByDate : AttendanceByDate): RecyclerView.Adapter<AttendanceDateAdapter.ViewHolder>() {

    var context: Context
    var studentAttendenceByDate: AttendanceByDate

    init {
        this.context = context
        this.studentAttendenceByDate = listStudentAttendsByDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.attendance_date_adapter, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return studentAttendenceByDate.resultlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var studentDateAttendance = studentAttendenceByDate.resultlist.get(position)
        holder.studentName.text = studentDateAttendance.firstname
        holder.student_attendence_id.text = studentDateAttendance.attendenceTypeId.toString()
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
