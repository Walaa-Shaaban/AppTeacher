package com.selwan.schools365teacher.ui.attendance.attendance_report.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.data.model.attendance.AttendanceReport
import com.selwan.schools365teacher.data.model.attendance.Resultlist

class AttendanceReportAdapter(context: Context, listStudentByReport) : RecyclerView.Adapter<> {

    var context: Context
    var studentAttendence: List<AttendanceReport>

    init {
        this.context = context
        this.studentAttendence =
    }


    class ViewHolder :  RecyclerView.ViewHolder{


    }
}