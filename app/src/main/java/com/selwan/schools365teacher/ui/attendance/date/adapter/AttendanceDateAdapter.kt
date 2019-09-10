package com.selwan.schools365teacher.ui.attendance.date.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.AttendanceByDate
import com.selwan.schools365teacher.data.utils.AttendanceState

class AttendanceDateAdapter
    (context : Context, var studentAttendanceReport : AttendanceByDate): RecyclerView.Adapter<AttendanceDateAdapter.ViewHolder>() {

    var context: Context
    var getStudentAttendanceReport: AttendanceByDate

    init {
        this.context = context
        this.getStudentAttendanceReport = studentAttendanceReport
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.attendance_date_adapter, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return getStudentAttendanceReport.resultlist.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Add item in xml ...
        var studentDateAttendance = getStudentAttendanceReport.resultlist.get(position)
        holder.studentName.text = studentDateAttendance.firstname
        var get_attendance_id = studentDateAttendance.attendenceTypeId!!.toString()
        holder.student_attendence_id.text =
            AttendanceState.StateAttendance(get_attendance_id).get(1)
                .toString()
        holder.student_attendence_id.setTextColor(
            Integer.valueOf(
                AttendanceState.StateAttendance(get_attendance_id).get(0)
                    .toString()
            )
        )
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
