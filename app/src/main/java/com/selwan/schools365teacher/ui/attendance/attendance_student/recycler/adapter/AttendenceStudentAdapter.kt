package com.selwan.schools365teacher.ui.attendance.attendance_student.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.Resultlist
import com.selwan.schools365teacher.ui.attendance.attendance_student.adapter.AttendenceStudentAdapter.ViewHolder

class AttendenceStudentAdapter (context : Context, studentAttends : List<Resultlist>): RecyclerView.Adapter<ViewHolder>() {

    var context: Context
    var studentAttendence: List<Resultlist>

    init {
        this.context = context
        this.studentAttendence = studentAttends
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.attendence_adapter, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return studentAttendence.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.studentName.text = studentAttendence.get(position).firstname
        holder.student_attendence_id.text = studentAttendence.get(position).attendenceTypeId.toString()
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
