package com.selwan.schools365teacher.ui.event.main

import android.app.usage.UsageEvents
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.ui.event.add_new.AddEvent1
import kotlinx.android.synthetic.main.event_main_fragment.*
import java.lang.StringBuilder

class EventMainFragment : Fragment() {

    companion object {
        fun newInstance() = EventMainFragment()
    }

    private lateinit var viewModel: EventMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            com.selwan.schools365teacher.R.layout.event_main_fragment,
            container,
            false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var date: String? = null
        var allEvent: AllEvent? = null

        viewModel = ViewModelProviders.of(this).get(EventMainViewModel::class.java)
        viewModel.allEvent.observe(this, Observer {
            allEvent = it
        })

//        calender_event.initCalderItemClickCallback(CalenderDayClickListener { dayContainerModel ->
//            var date = StringBuilder()
//            date.append("${dayContainerModel.year.toString()}-")
//            if (getMonthByNum(dayContainerModel.month)<10){
//                date.append("0${getMonthByNum(dayContainerModel.month)}-")
//            }
//            else{
//                date.append("${getMonthByNum(dayContainerModel.month)}-")
//            }
//            if (dayContainerModel.day<10) {
//                date.append("0${dayContainerModel.day}")
//            }else{
//                date.append("${dayContainerModel.day}")
//            }
//            if (date != null) {
//                rec_event.layoutManager = LinearLayoutManager(this.context)
//                rec_event.adapter = EventAdapter(this.context!!, allEvent!!, date.toString()!!)
//            } else {
//                val snackbar =
//                    Snackbar.make(
//                        view!!,
//                        "Please choose date",
//                        Snackbar.LENGTH_LONG
//                    )
//                val sbView = snackbar.view
//                sbView.setBackgroundResource(R.color.green)
//                snackbar.show()
//            }
//        })
        add_new_event.setOnClickListener {
            startActivity(Intent(this.context, AddEvent1::class.java))
        }

    }


    fun getMonthByNum(month: String): Int {
        when (month) {
            "January" -> return 1
            "February" -> return 2
            "March" -> return 3
            "April" -> return 4
            "May" -> return 5
            "June" -> return 6
            "July" -> return 7
            "August" -> return 8
            "September" -> return 9
            "October" -> return 10
            "November" -> return 11
            "December " -> return 12
        }
        return 0

    }
}
