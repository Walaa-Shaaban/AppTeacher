package com.selwan.schools365teacher.ui.notification.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.notification.adapter.NotificationAdapter
import kotlinx.android.synthetic.main.notification_fragment.*
import java.lang.StringBuilder

class NotificationFragment : Fragment() {


    private lateinit var viewModel: NotificationViewModel

    companion object;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notification_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(NotificationViewModel::class.java)
        viewModel.getAllNotification.observe(this, Observer {
            rec_notification.layoutManager = LinearLayoutManager(this.context)
            rec_notification.adapter = NotificationAdapter(this.context!!, it)
        })

    }


}
