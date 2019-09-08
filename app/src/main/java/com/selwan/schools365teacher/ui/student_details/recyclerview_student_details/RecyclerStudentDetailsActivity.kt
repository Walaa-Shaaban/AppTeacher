package com.selwan.schools365teacher.ui.student_details.recyclerview_student_details

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.ui.student_details.recyclerview_student_details.adapter.StudentsDetailsAdapter
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_recycler_student_details.*

class RecyclerStudentDetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_student_details)
        recycler_student_details.layoutManager = LinearLayoutManager(this)

        getViewModel().allStudentinSection.observe(this, Observer {
            recycler_student_details.adapter = StudentsDetailsAdapter(it, this)
        })


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
