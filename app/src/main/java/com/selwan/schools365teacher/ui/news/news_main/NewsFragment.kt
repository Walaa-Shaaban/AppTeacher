package com.selwan.schools365teacher.ui.news.news_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.news.news_main.adapter.NewsAdapter
import kotlinx.android.synthetic.main.news_fragment.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.selwan.schools365teacher.R.layout.news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar as Toolbar?)
        (activity as AppCompatActivity).supportActionBar?.title = "Our News"

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
            rec_news.layoutManager = LinearLayoutManager(this.context)
            viewModel.getNews.observe(this, Observer {
                rec_news.adapter = NewsAdapter(this.context!!, it)
            })
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(com.selwan.schools365teacher.R.color.redHighDelete)
            snackbar.show()
        }

    }

}
