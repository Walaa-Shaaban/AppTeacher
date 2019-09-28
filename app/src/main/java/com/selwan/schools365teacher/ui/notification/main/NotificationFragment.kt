package com.selwan.schools365teacher.ui.notification.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.notification_fragment.*

class NotificationFragment : Fragment() {


    private lateinit var viewModel: NotificationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notification_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotificationViewModel::class.java)
        viewModel.getNotificationInfo.observe(this, Observer {
            txt.text = "${it["title"]}---  ${it["contact"]}"
        })
    }

}
