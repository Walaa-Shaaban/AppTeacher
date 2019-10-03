package com.selwan.schools365teacher.ui.notification.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.notification.NotificationResponse

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private var context: Context
    private var notificationList: List<NotificationResponse>

    constructor(context: Context, notificationList: List<NotificationResponse>) : super() {
        this.context = context
        this.notificationList = notificationList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.notification_item, parent, false)
        return NotificationViewHolder(inflater)

    }

    override fun getItemCount(): Int {

        return notificationList.size
    }


    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.title_notification.text = notificationList.get(position).title
        holder.body_notification.text = notificationList.get(position).body

    }


    class NotificationViewHolder : RecyclerView.ViewHolder {

        var title_notification: TextView
        var body_notification: TextView

        constructor(itemView: View) : super(itemView) {
            title_notification = itemView.findViewById(R.id.actv_title)
            body_notification = itemView.findViewById(R.id.actv_message)
        }


    }
}