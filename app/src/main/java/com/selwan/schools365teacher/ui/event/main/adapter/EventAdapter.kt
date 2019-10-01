package com.selwan.schools365teacher.ui.event.main.adapter

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.event.AllEvent


class EventAdapter(context: Context, listEvent: AllEvent, var date: String) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    var context: Context
    var listEvent: AllEvent

    init {
        this.context = context
        this.listEvent = listEvent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(com.selwan.schools365teacher.R.layout.item_event, parent, false)
        return EventAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return listEvent.events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if (listEvent.events.get(position).startDate.equals("2019-09-06 00:00:00")) {
            holder.title.text = listEvent.events.get(position).eventTitle
            holder.date_event.text = listEvent.events.get(position).startDate
        }


    }


    class ViewHolder : RecyclerView.ViewHolder {
        var title: TextView
        var date_event: TextView
        var linear: LinearLayout


        constructor(itemView: View) : super(itemView) {
            title = itemView.findViewById(R.id.event_title)
            date_event = itemView.findViewById(R.id.event_date_start)
            linear = itemView.findViewById(R.id.linear_event)
        }

    }
}
