package com.selwan.schools365teacher.ui.news.news_details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.news_details_fragment.*

class NewsDetailsFragment(
    var title: String,
    var img_url: String,
    var desc: String,
    var date: String
) : Fragment() {


    private lateinit var viewModel: NewsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        title_new_details.text = title
        desc_new_details.text = desc
        date_new_details.text = date

        Glide
            .with(this)
            .load(img_url)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(img_new_details)


    }

}
