package com.selwan.schools365teacher.ui.event.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.data.model.news.News
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class EventMainRepository(var compositeDisposable: CompositeDisposable) {

    var allEvent = MutableLiveData<AllEvent>()
    fun fetchAllEvent(): LiveData<AllEvent> {

        compositeDisposable.add(
            ApiUtils.apiService.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        allEvent.value = it
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
        return allEvent
    }


}