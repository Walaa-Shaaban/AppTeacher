package com.selwan.schools365teacher.ui.news.news_main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.news.News
import com.selwan.schools365teacher.ui.news.news_details.NewsDetailsActivity

class NewsAdapter (context: Context, listNews: News) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    var context: Context
    var listNews: News

    init {
        this.context = context
        this.listNews= listNews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item_our_news, parent, false)
        return NewsAdapter.ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return listNews.items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = listNews.items.get(position).title
        holder.desc.text = listNews.items.get(position).description
        holder.date_new.text = listNews.items.get(position).date
        holder.linear.setOnClickListener {
            var intent = Intent(holder.itemView.context, NewsDetailsActivity::class.java)
            intent.putExtra("title", listNews.items.get(position).title)
            intent.putExtra("date", listNews.items.get(position).date)
            intent.putExtra("desc", listNews.items.get(position).description)
            intent.putExtra("image", listNews.items.get(position).feature_image)
            context.startActivity(intent)
        }
    }


    class ViewHolder :  RecyclerView.ViewHolder{
        var title: TextView
        var date_new: TextView
        var desc :  TextView
        var linear: ConstraintLayout

        constructor(itemView: View) : super(itemView) {
            title = itemView.findViewById(R.id.actv_label_news)
            date_new = itemView.findViewById(R.id.actv_news_date)
            linear = itemView.findViewById(R.id.linear_new)
            desc = itemView.findViewById(R.id.aptv_news)
        }

    }
}