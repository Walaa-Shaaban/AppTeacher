package com.selwan.schools365teacher.ui.examination.tabs.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import com.selwan.schools365teacher.ui.examination.view_mark.ExaminationViewMarkActivity


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
            holder.viewMark.setOnClickListener {
                var intent = Intent(this.context, ExaminationViewMarkActivity::class.java)
                intent.putExtra("exam_id", listExam.examSchedule.get(position).exam_id)
                intent.putExtra("class_id", ExaminationMainFragment.class_id)
                intent.putExtra("section_id", ExaminationMainFragment.section_id)
                this.context.startActivity(intent)
            }
        } else {
            holder.linear_exam_adapter.layoutParams = LinearLayout.LayoutParams(
                0, 0
            )
        }
    }


    class ViewHolder :  RecyclerView.ViewHolder{
        var exam_title : TextView
        var exam_date: TextView
        var exam_room : TextView
        var linear_exam_adapter: LinearLayout
        var viewMark: Button

        constructor(itemView: View) : super(itemView) {
            linear_exam_adapter = itemView.findViewById(R.id.linear_exam_adapter)
            exam_title = itemView.findViewById(R.id.txt_exam_title)
            exam_date = itemView.findViewById(R.id.txt_exam_date)
            exam_room = itemView.findViewById(R.id.txt_exam_room)
            viewMark = itemView.findViewById(R.id.view_mark)

        }

    }
}