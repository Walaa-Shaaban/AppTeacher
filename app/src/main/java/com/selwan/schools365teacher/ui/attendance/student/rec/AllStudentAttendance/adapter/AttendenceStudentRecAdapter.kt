package com.selwan.schools365teacher.ui.attendance.student.rec.AllStudentAttendance.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.ui.attendance.student.rec.AllStudentAttendance.adapter.AttendenceStudentRecAdapter.ViewHolder
import com.selwan.schools365teacher.ui.attendance.student.rec.change_attendance.AttendanceChangeActivity
import io.reactivex.disposables.CompositeDisposable


class AttendenceStudentRecAdapter(context: Context, studentAttends: StudentAttendance) :
    RecyclerView.Adapter<ViewHolder>() {

    var context: Context
    var studentAttendence: StudentAttendance
    var compositeDisposable: CompositeDisposable

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

        holder.studentName.text = studentAttendence.resultlist.get(position).firstname
        if (studentAttendence.resultlist.get(position).attType != null) {
            holder.student_attendence_id.text =
                studentAttendence.resultlist.get(position).attType.toString()

        } else {
            holder.student_attendence_id.text = "Present"

        }

        holder.student_attendence_id.setOnClickListener {

            var intent = Intent(this.context, AttendanceChangeActivity::class.java)
            intent.putExtra(
                "attendence_id",
                studentAttendence.resultlist.get(position).attendenceId
            )
            intent.putExtra(
                "student_session",
                studentAttendence.resultlist.get(position).studentSessionId
            )
            this.context.startActivity(intent)
        }


    }

    fun getAttendanceType(attendanceTypeId: Int): String {
        return studentAttendence.attendencetypeslist.get(attendanceTypeId).type
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
