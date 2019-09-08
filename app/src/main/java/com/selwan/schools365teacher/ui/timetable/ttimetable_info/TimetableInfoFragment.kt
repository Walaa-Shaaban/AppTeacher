package com.selwan.schools365teacher.ui.timetable.ttimetable_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class TimetableInfoFragment : Fragment() {

    companion object {
        fun newInstance() = TimetableInfoFragment()
    }

    private lateinit var viewModel: TimetableInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.timetable_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TimetableInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
