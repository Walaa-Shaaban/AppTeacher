package com.selwan.schools365teacher.ui.examination.view_mark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.activity_view_mark.*

class ExaminationViewMarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mark)

        rec_view_mark.layoutManager = LinearLayoutManager(this)
        getViewModel().getAllViewMark.observe(this, Observer {
            rec_view_mark.adapter = AdapterViewMark(context = this, viewmark = it)
        })


    }

    fun getViewModel(): ExaminationViewMarkViewHolder {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ExaminationViewMarkViewHolder(
                    context = applicationContext,
                    class_id = intent.getStringExtra("class_id"),
                    section_id = intent.getStringExtra("section_id"),
                    exam_id = intent.getStringExtra("exam_id")
                ) as T
            }

        })[ExaminationViewMarkViewHolder::class.java]
    }
}
