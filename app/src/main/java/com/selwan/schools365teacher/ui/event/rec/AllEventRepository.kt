package com.selwan.schools365teacher.ui.event.rec


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.data.model.event.Event
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AllEventRepository(var compositeDisposable: CompositeDisposable, var date_start: String) {

    var allEventInDate = MutableLiveData<MutableList<Event>>()
    val list = mutableListOf<Event>()

    fun fetchAllEvent(): LiveData<MutableList<Event>> {

        compositeDisposable.add(
            ApiUtils.apiService.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        for (item in it.events) {
                            if (item.startDate.equals(date_start)) {
                                list.add(item)
                            }
                        }
                        allEventInDate.value = list

                    }, Consumer {
                        val snackbar =
                            Snackbar.make(
                                TimetableMainFragment.view!!,
                                "Something Went Error ... The data couldn't be read",
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                ))
        return allEventInDate
    }


}