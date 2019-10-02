package com.selwan.schools365teacher.ui.event.rec.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.data.model.event.Event


class EventAdapter(context: Context, listEvent: List<Event>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    var context: Context
    var listEvent: List<Event>

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
        return listEvent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = listEvent.get(position).eventTitle
        holder.date_event.text = listEvent.get(position).startDate



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
