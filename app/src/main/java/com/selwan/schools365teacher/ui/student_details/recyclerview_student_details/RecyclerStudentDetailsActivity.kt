package com.selwan.schools365teacher.ui.student_details.recyclerview_student_details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import com.selwan.schools365teacher.ui.student_details.recyclerview_student_details.adapter.StudentsDetailsAdapter
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_recycler_student_details.*

class RecyclerStudentDetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_student_details)

        if (NetworkUtils.isNetworkConnected(this)) {
            recycler_student_details.layoutManager = LinearLayoutManager(this)
            getViewModel().allStudentinSection.observe(this, Observer {
                recycler_student_details.adapter = StudentsDetailsAdapter(it, this)
            })
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()

        }


    }

    fun getViewModel(): RecyclerviewDetailsViewmodel {

        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return RecyclerviewDetailsViewmodel()
                as T
            }
        })[RecyclerviewDetailsViewmodel::class.java]
    }
}
