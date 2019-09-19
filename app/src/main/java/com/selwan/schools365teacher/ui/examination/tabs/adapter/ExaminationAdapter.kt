package com.selwan.schools365teacher.ui.examination.tabs.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule

class ExaminationAdapter(context: Context, listExam: AllExamSchedule, var exam_id: String) :
    RecyclerView.Adapter<ExaminationAdapter.ViewHolder>() {

    var context: Context
    var listExam: AllExamSchedule

    init {
        this.context = context
        this.listExam= listExam
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exam, parent, false)
        return ExaminationAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return listExam.examSchedule.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (listExam.examSchedule.get(position).exam_id.equals(exam_id)) {
            holder.exam_title.text = listExam.examSchedule.get(position).subject_name
            holder.exam_date.text = listExam.examSchedule.get(position).date_of_exam
            holder.exam_room.text = listExam.examSchedule.get(position).room_no
        }


    }


    class ViewHolder :  RecyclerView.ViewHolder{
        var exam_title : TextView
        var exam_date: TextView
        var exam_room : TextView

        constructor(itemView: View) : super(itemView) {
            exam_title = itemView.findViewById(R.id.txt_exam_title)
            exam_date = itemView.findViewById(R.id.txt_exam_date)
            exam_room = itemView.findViewById(R.id.txt_exam_room)
        }

    }
}