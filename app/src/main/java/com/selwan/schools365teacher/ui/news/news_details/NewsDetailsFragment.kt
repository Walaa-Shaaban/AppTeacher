package com.selwan.schools365teacher.ui.news.news_details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.news_details.*

class NewsDetailsFragment(
    var title: String,
    var desc: String,
    var date: String,
    var image: String
) : Fragment() {


    private lateinit var viewModel: NewsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        actv_label_news2.text = title
        aptv_news2.text = desc
        actv_news_date2.text = date



    }

}
