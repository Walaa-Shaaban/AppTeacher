package com.selwan.schools365teacher.ui.event.add_new

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R


class AddEventFragment : Fragment() {

    companion object {
        fun newInstance() = AddEventFragment()
    }

    private lateinit var viewModel: AddEventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.add_event_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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

    fun getViewModel(): AddEventViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AddEventViewModel(
                    title = "ahalan",
                    startDate = "2019-12-19",
                    description = "",
                    eventType = "public",
                    endTime = "16/9/2019"
                ) as T
            }

        })[AddEventViewModel::class.java]
    }

}
