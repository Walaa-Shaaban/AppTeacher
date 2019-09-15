package com.selwan.schools365teacher.ui.homework.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.homework.add_new.HomeworkAddNewActivity
import com.selwan.schools365teacher.ui.homework.main.adapter.HomeworkMainAdapter
import kotlinx.android.synthetic.main.homework_main_fragment.*

class HomeworkMainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.homework_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rec_homework.layoutManager = LinearLayoutManager(this.context)
        getViewModel().getHomeworkList.observe(this, Observer {
            rec_homework.adapter = HomeworkMainAdapter(this.context!!, it)
        })
        add_new_homework.setOnClickListener {
            startActivity(Intent(this.context, HomeworkAddNewActivity::class.java))
        }

    }

    fun getViewModel(): HomeworkMainViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeworkMainViewModel() as T
            }

        })[HomeworkMainViewModel::class.java]
    }

}
