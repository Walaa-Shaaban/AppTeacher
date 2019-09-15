package com.selwan.schools365teacher.ui.communication.main

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
import com.selwan.schools365teacher.ui.communication.main.adapter.CommunicationNoticBoardAdapter
import kotlinx.android.synthetic.main.communication_main_fragment.*

class CommunicationNoticBoardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.communication_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rec_notic_board.layoutManager = LinearLayoutManager(this.context)
        getViewModel().getNoticBoard.observe(this, Observer {
            rec_notic_board.adapter = CommunicationNoticBoardAdapter(this.context!!, it)
        })

    }


    fun getViewModel(): CommunicationNoticBoardViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CommunicationNoticBoardViewModel() as T
            }

        })[CommunicationNoticBoardViewModel::class.java]
    }


}
