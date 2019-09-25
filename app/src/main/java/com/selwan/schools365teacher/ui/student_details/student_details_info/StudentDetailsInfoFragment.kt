package com.selwan.schools365teacher.ui.student_details.student_details_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.utils.NetworkUtils
import kotlinx.android.synthetic.main.student_details_info_fragment.*

class StudentDetailsInfoFragment(var student_id : String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.student_details_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (NetworkUtils.isNetworkConnected(this.context!!)) {
            getViewModel().getStudentDetailsInfo.observe(this, Observer {
                txt_stu_info.text =
                    "${it.firstname}\n${it.father_phone}\n ${it.city}\n ${it.current_address}"
            })
        } else {
            val snackbar =
                Snackbar.make(view!!, "Connection Error ... Try again", Snackbar.LENGTH_LONG)
            val sbView = snackbar.view
            sbView.setBackgroundResource(R.color.redHighDelete)
            snackbar.show()

        }


    }


    fun getViewModel(): StudentDetailsInfoViewModel{
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return StudentDetailsInfoViewModel(student_id = student_id) as T
            }

        })[StudentDetailsInfoViewModel::class.java]
    }


}
