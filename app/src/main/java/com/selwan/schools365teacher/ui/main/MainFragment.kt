package com.selwan.schools365teacher.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.attendance.AttendanceActivity
import com.selwan.schools365teacher.ui.event.main.EventMainActivity
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainActivity
import com.selwan.schools365teacher.ui.homework.AllHomework.AllHomeworkActivity
import com.selwan.schools365teacher.ui.news.news_main.NewsActivity
import com.selwan.schools365teacher.ui.notification.main.NotificationActivity
import com.selwan.schools365teacher.ui.student_details.StudentDetailsActivity
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainActivity
import kotlinx.android.synthetic.main.khalid_fragment_main_screen.*


class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.khalid_fragment_main_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        details.setOnClickListener {
            it.context.startActivity(Intent(this.context, StudentDetailsActivity::class.java))
        }
        timetable.setOnClickListener {
            it.context.startActivity(Intent(this.context, TimetableMainActivity::class.java))
        }
        attendance.setOnClickListener {
            it.context.startActivity(Intent(this.context, AttendanceActivity::class.java))
        }
//        exam.setOnClickListener {
//            it.context.startActivity(Intent(this.context, ExaminationMainActivity::class.java))
//        }

        our_news.setOnClickListener {
            it.context.startActivity(Intent(this.context, NewsActivity::class.java))
        }

        notification.setOnClickListener {
            it.context.startActivity(Intent(this.context, NotificationActivity::class.java))
        }

        actv_event.setOnClickListener {
            it.context.startActivity(Intent(this.context, EventMainActivity::class.java))
        }

        our_homework.setOnClickListener{
            it.context.startActivity(Intent(this.context, AllHomeworkActivity::class.java))
        }
    }

    }

