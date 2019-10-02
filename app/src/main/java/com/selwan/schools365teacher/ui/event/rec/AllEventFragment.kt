package com.selwan.schools365teacher.ui.event.rec

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.event.rec.adapter.EventAdapter
import kotlinx.android.synthetic.main.all_event_fragment.*

class AllEventFragment(var start_date: String) : Fragment() {


    private lateinit var viewModel: AllEventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.all_event_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getViewModel().allEvent.observe(this, Observer {
            rec_event_all.layoutManager = LinearLayoutManager(this.context)
            rec_event_all.adapter = EventAdapter(this.context!!, it)
        })

    }

    fun getViewModel(): AllEventViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AllEventViewModel(start_date) as T
            }

        })[AllEventViewModel::class.java]
    }

}
