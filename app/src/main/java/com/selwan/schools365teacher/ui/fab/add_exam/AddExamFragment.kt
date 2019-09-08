package com.selwan.schools365teacher.ui.fab.add_exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class AddExamFragment : Fragment() {

    companion object {
        fun newInstance() = AddExamFragment()
    }

    private lateinit var viewModel: AddExamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_exam_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddExamViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
