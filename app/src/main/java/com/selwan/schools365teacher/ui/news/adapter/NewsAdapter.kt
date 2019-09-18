package com.selwan.schools365teacher.ui.news.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.news.News
import com.selwan.schools365teacher.ui.attendance.report.report_info.overview.AttendanaceReportInfoActivity

class NewsAdapter (context: Context, listNews: News) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    var context: Context
    var listNews: News

    init {
        this.context = context
        this.listNews= listNews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return listNews.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = listNews.items.get(position).title
        holder.desc.text = listNews.items.get(position).description
        Glide
            .with(context)
            .load(listNews.items.get(position).feature_image)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.imgNews)


    }


    class ViewHolder :  RecyclerView.ViewHolder{
        var imgNews : ImageView
        var title: TextView
        var desc :  TextView

        constructor(itemView: View) : super(itemView) {
            imgNews = itemView.findViewById(R.id.img_new)
            title = itemView.findViewById(R.id.title)
            desc = itemView.findViewById(R.id.description)
        }

    }
}