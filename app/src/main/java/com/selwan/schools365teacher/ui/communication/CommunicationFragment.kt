package com.selwan.schools365teacher.ui.communication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.selwan.schools365teacher.R

class CommunicationFragment : Fragment() {

    companion object {
        fun newInstance() = CommunicationFragment()
    }

    private lateinit var viewModel: CommunicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.communication_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CommunicationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
