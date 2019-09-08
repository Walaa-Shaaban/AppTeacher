package com.selwan.schools365teacher.ui.fab.add_homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class AddHomeworkFragment : Fragment() {

    companion object {
        fun newInstance() = AddHomeworkFragment()
    }

    private lateinit var viewModel: AddHomeworkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_homework_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddHomeworkViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
