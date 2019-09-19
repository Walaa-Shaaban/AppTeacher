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
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.examination.add_new_exam.AddNewExamActivity
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

        rec_exam.layoutManager = LinearLayoutManager(this.context)
        getViewModel().fetchAllExams.observe(this, Observer {
            rec_exam.adapter = ExaminationAdapter(this.context!!, it, exam_id)
        })

        fab_add_new.setOnClickListener { view ->
            startActivity(Intent(this.context, AddNewExamActivity::class.java))
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
