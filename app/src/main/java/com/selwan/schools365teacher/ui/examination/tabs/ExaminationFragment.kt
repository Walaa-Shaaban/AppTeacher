package com.selwan.schools365teacher.ui.examination.tabs

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
import com.selwan.schools365teacher.ui.examination.tabs.adapter.ExaminationAdapter
import kotlinx.android.synthetic.main.examination_fragment.*

class ExaminationFragment(var exam_id: String) : Fragment() {



    private lateinit var viewModel: ExaminationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.examination_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            rec_exam.layoutManager = LinearLayoutManager(this.context)
            getViewModel().fetchAllExams.observe(this, Observer {
                rec_exam.adapter = ExaminationAdapter(this.context!!, it, exam_id)
            })


        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()

        }
    }

    fun getViewModel(): ExaminationViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ExaminationViewModel(context!!) as T
            }

        })[ExaminationViewModel::class.java]
    }


}
