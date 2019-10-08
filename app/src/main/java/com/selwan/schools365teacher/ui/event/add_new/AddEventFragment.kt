package com.selwan.schools365teacher.ui.event.add_new

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import kotlinx.android.synthetic.main.add_event_fragment.*


class AddEventFragment : Fragment() {



    var date: String ?= null
    var textType: String ? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.add_event_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        acb_save.setOnClickListener{
            getViewModel().postAddEvent.observe(this, Observer {
                val snackbar =
                    Snackbar.make(
                        view!!,
                        it.msg,
                        Snackbar.LENGTH_LONG
                    )
                val sbView = snackbar.view
                sbView.setBackgroundResource(R.color.green)
                snackbar.show()
            })
        }

        acet_date.setOnClickListener{
            DatePickerDialog(this.context!!, R.style.DialogTheme,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    var month = monthOfYear
                    month = month + 1

                    date = "${year}-${month}-${dayOfMonth}"
                    acet_date.text = date
                }, 2019, 9, 6
            ).show()

        }

        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                R.id.public_event -> textType = "Public"
                R.id.private_event -> textType = "private"
                R.id.all_teacher_event -> textType = "All Teacher"
        }
        }
    }

    fun getViewModel(): AddEventViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AddEventViewModel(
                    title = acet_event_title.text.toString(),
                    startDate = date.toString(),
                    description = acet_description.text.toString(),
                    eventType = textType.toString(),
                    endTime = ""
                ) as T
            }

        })[AddEventViewModel::class.java]
    }

}
