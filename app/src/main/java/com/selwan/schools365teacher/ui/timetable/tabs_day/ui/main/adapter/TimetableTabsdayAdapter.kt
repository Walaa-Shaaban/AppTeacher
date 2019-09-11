package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.timetable.Timetable

class TimetableTabsdayAdapter : RecyclerView.Adapter<TimetableTabsdayAdapter.ViewHolder> {

    var context: Context
    var timetable: Timetable

    constructor(timetable: Timetable, context: Context) : super() {
        this.timetable = timetable
        this.context = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_timetable, parent, false)
        return ViewHolder(inflater)

    }

    override fun getItemCount(): Int {
        return timetable.result_array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.subject.text = timetable.result_array.get(position).name
        holder.room_no.text = timetable.result_array.get(position).items.Monday.room_no
        holder.end.text = timetable.result_array.get(position).items.Monday.end_time
        holder.start.text = timetable.result_array.get(position).items.Monday.start_time


    }

    class ViewHolder : RecyclerView.ViewHolder {

        var subject: TextView
        var room_no: TextView
        var start: TextView
        var end: TextView

        constructor(itemView: View) : super(itemView) {
            subject = itemView.findViewById(R.id.subject)
            room_no = itemView.findViewById(R.id.room_no)
            start = itemView.findViewById(R.id.start_time)
            end = itemView.findViewById(R.id.end_time)
        }


    }
}