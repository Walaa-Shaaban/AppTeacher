package com.selwan.schools365teacher.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.attendance.AttendanceActivity
import com.selwan.schools365teacher.ui.communication.CommunicationActivity
import com.selwan.schools365teacher.ui.news.NewsActivity
import com.selwan.schools365teacher.ui.student_details.StudentDetailsActivity
import com.selwan.schools365teacher.ui.timetable.TimetableActivity
import kotlinx.android.synthetic.main.fragment_main_screen.*

class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        details.setOnClickListener {
            it.context.startActivity(Intent(this.context, StudentDetailsActivity::class.java))
        }
        timetable.setOnClickListener {
            it.context.startActivity(Intent(this.context, TimetableActivity::class.java))
        }
        attendance.setOnClickListener {
            it.context.startActivity(Intent(this.context, AttendanceActivity::class.java))
        }
        exam.setOnClickListener {
            it.context.startActivity(Intent(this.context, TimetableActivity::class.java))
        }
        communication.setOnClickListener {
            it.context.startActivity(Intent(this.context, CommunicationActivity::class.java))
        }
        our_news.setOnClickListener {
            it.context.startActivity(Intent(this.context, NewsActivity::class.java))
        }
    }
}
