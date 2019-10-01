package com.selwan.schools365teacher.ui.event.add_new

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.data.model.event.SaveEvent
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AddEventRepository(var compositeDisposable: CompositeDisposable) {

    var addEvent = MutableLiveData<SaveEvent>()
    fun PostAddEvent(
        title: String,
        description: String,
        endTime: String,
        startDate: String,
        eventType: String
    ): LiveData<SaveEvent> {
        compositeDisposable.add(
            ApiUtils.apiService.addNewEvent(
                title = title,
                description = description,
                endTime = endTime,
                event_type = eventType,
                start_date = startDate
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        addEvent.value = it
                    }, Consumer {
                        val snackbar =
                            Snackbar.make(
                                view!!,
                                "Something Went Error ... The data couldn't be read",
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                ))
        return addEvent
    }


}