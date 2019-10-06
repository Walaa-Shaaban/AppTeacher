package com.selwan.schools365teacher.ui.homework.AllHomework

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
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.homework.add_new.add_new_continue.HomeworkAddNewActivity
import com.selwan.schools365teacher.ui.homework.AllHomework.adapter.AllHomeworkAdapter
import com.selwan.schools365teacher.ui.homework.add_new.add_new_main.HomeworkAddNewMainActivity
import kotlinx.android.synthetic.main.homework_main_fragment.*

class AllHomeworkFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.homework_main_fragment, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            rec_homework.layoutManager = LinearLayoutManager(this.context)
            getViewModel().getHomeworkList.observe(this, Observer {
                rec_homework.adapter = AllHomeworkAdapter(this.context!!, it)
            })
            add_new_homework.setOnClickListener {
                startActivity(Intent(this.context, HomeworkAddNewMainActivity::class.java))
            }
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()

        }

    }

    fun getViewModel(): AllHomeworkViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AllHomeworkViewModel() as T
            }

        })[AllHomeworkViewModel::class.java]
    }

}
