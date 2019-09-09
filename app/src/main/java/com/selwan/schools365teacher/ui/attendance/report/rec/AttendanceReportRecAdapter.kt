package com.selwan.schools365teacher.ui.attendance.report.rec

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.AttendanceReport
import com.selwan.schools365teacher.ui.attendance.report.report_info.overview.AttendanaceReportInfoActivity
import com.selwan.schools365teacher.ui.attendance.report.report_info.overview.AttendanceReportInfoFragment
import com.selwan.schools365teacher.ui.attendance.report.report_info.overview.AttendanceReportInfoRepository
import com.selwan.schools365teacher.ui.attendance.report.report_info.overview.AttendanceReportInfoViewModel

class AttendanceReportRecAdapter(context: Context, listStudentByReport: AttendanceReport) : RecyclerView.Adapter<AttendanceReportRecAdapter.ViewHolder>(){

    var context: Context
    var studentAttendence: AttendanceReport

    init {
        this.context = context
        this.studentAttendence = listStudentByReport
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attendence_report_adapter, parent, false)
        return AttendanceReportRecAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return studentAttendence.student_array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.studentName.text = studentAttendence.student_array.get(position).firstname
        holder.attendancePercentage.text = studentAttendence.student_array.get(position).lastname
        holder.itemView.setOnClickListener{
            var intent  = Intent(this.context, AttendanaceReportInfoActivity ::class.java)
            intent.putExtra("student_id",studentAttendence.student_array.get(position).student_session_id)
            context.startActivity(intent)

        }

    }


    class ViewHolder :  RecyclerView.ViewHolder{
        var attendancePercentage : TextView
        var studentName: TextView

        constructor(itemView: View) : super(itemView) {
            studentName = itemView.findViewById(R.id.student_name)
            attendancePercentage = itemView.findViewById(R.id.student_percentage)
        }

    }
}