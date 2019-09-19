package com.selwan.schools365teacher.ui.examination.view_mark

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.ViewMark


class AdapterViewMark(context: Context, viewmark: ViewMark) :
    RecyclerView.Adapter<AdapterViewMark.ViewHolder>() {

    var context: Context
    var viewmark: ViewMark

    init {
        this.context = context
        this.viewmark = viewmark
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exam, parent, false)
        return AdapterViewMark.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return viewmark.examSchedule.result.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text =
            "${viewmark.examSchedule.result.get(position).firstname} ${viewmark.examSchedule.result.get(
                position
            ).lastname}"
        holder.mark_total_.text = viewmark.examSchedule.result.get(position).grand_total

    }


    class ViewHolder : RecyclerView.ViewHolder {
        var name: TextView
        var mark_total_: TextView


        constructor(itemView: View) : super(itemView) {
            name = itemView.findViewById(R.id.txtName)
            mark_total_ = itemView.findViewById(R.id.txtmark)

        }

    }
}