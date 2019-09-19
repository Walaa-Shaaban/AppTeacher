package com.selwan.schools365teacher.ui.examination.tabs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
        viewModel = ViewModelProviders.of(this).get(ExaminationViewModel::class.java)
        rec_exam.layoutManager = LinearLayoutManager(this.context)
        viewModel.fetchAllExams.observe(this, Observer {
            rec_exam.adapter = ExaminationAdapter(this.context!!, it, exam_id)
        })

        fab_add_new.setOnClickListener { view ->
            startActivity(Intent(this.context, AddNewExamActivity::class.java))
        }
    }

}
