package com.selwan.schools365teacher.ui.communication.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.communication.NoticBoard

class CommunicationNoticBoardAdapter(context: Context, noticBoard: NoticBoard) :
    RecyclerView.Adapter<CommunicationNoticBoardAdapter.ViewHolder>() {

    var context: Context
    var noticBoard: NoticBoard

    init {
        this.context = context
        this.noticBoard = noticBoard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_communication_notic_board, parent, false)
        return CommunicationNoticBoardAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return noticBoard.notificationlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.noticTitle.text = noticBoard.notificationlist.get(position).title
        holder.noticDate.text = noticBoard.notificationlist.get(position).date


    }


    class ViewHolder : RecyclerView.ViewHolder {
        var noticTitle: TextView
        var noticDate: TextView

        constructor(itemView: View) : super(itemView) {
            noticTitle = itemView.findViewById(R.id.notic_title)
            noticDate = itemView.findViewById(R.id.notic_date)
        }

    }
}