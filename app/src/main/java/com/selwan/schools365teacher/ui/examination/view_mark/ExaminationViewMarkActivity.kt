package com.selwan.schools365teacher.ui.examination.view_mark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import kotlinx.android.synthetic.main.activity_view_mark.*

class ExaminationViewMarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_mark)

        if (NetworkUtils.isNetworkConnected(this)) {
            rec_view_mark.layoutManager = LinearLayoutManager(this)
            getViewModel().getAllViewMark.observe(this, Observer {
                rec_view_mark.adapter = AdapterViewMark(context = this, viewmark = it)
            })
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()

        }


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
