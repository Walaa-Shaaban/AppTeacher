package com.selwan.schools365teacher.ui.homework.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.homework.HomeworkList

class HomeworkMainAdapter(context: Context, homeworkList: HomeworkList) :
    RecyclerView.Adapter<HomeworkMainAdapter.ViewHolder>() {

    var context: Context
    var homeworkList: HomeworkList

    init {
        this.context = context
        this.homeworkList = homeworkList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_homework_list, parent, false)
        return HomeworkMainAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return homeworkList.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.homeworkName.text = homeworkList.items.get(position).name
        holder.homeworkClass.text = homeworkList.items.get(position).createDate.toString()
        holder.homeworkSection.text =
            "${homeworkList.items.get(position).classId}/${homeworkList.items.get(position).section}"


    }


    class ViewHolder : RecyclerView.ViewHolder {
        var homeworkName: TextView
        var homeworkClass: TextView
        var homeworkSection: TextView

        constructor(itemView: View) : super(itemView) {
            homeworkName = itemView.findViewById(R.id.homework_name)
            homeworkClass = itemView.findViewById(R.id.homework_class)
            homeworkSection = itemView.findViewById(R.id.homework_section)

        }

    }
}