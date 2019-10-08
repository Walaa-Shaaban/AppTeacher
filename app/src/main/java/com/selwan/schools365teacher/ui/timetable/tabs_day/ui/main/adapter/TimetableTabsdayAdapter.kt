package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.timetable.Timetable
import com.selwan.schools365teacher.data.model.timetable.day_info

class TimetableTabsdayAdapter : RecyclerView.Adapter<TimetableTabsdayAdapter.ViewHolder> {

    class DayInfoWithName {
        var name: String
        var dayInfo: day_info

        constructor(name: String, day: day_info) {
            this.name = name
            this.dayInfo = day
        }
    }

    var context: Context
    var timetable: Timetable
    var tabText: String

    constructor(timetable: Timetable, context: Context, tabText: String) : super() {
        this.timetable = timetable
        this.context = context
        this.tabText = tabText

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.timetaple_item, parent, false)
        return ViewHolder(inflater)

    }

    override fun getItemCount(): Int {
        return allItems().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = allItems()[position]

        holder.subject.text = item.name
        holder.start.text =  "${item.dayInfo.start_time} - ${item.dayInfo.end_time}"

    }

    fun allItems(): List<DayInfoWithName> {
        return timetable.result_array.mapNotNull {
            val day = it.items.get(tabText)
            if (day != null) {
                DayInfoWithName(name = it.name, day = day)
            } else {
                null
            }
        }
    }

    class ViewHolder : RecyclerView.ViewHolder {

        var subject: TextView
        var start: TextView

        constructor(itemView: View) : super(itemView) {
            subject = itemView.findViewById(R.id.txt_exam_title)
            start = itemView.findViewById(R.id.time_start)
        }


    }
}