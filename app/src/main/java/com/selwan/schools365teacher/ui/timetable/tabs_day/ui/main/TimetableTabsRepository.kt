package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.timetable.Timetable
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class TimetableTabsRepository(var compositeDisposable: CompositeDisposable) {

    val getAllTimetable = MutableLiveData<Timetable>()

    init {
        fetchAllTimetable()
    }


    fun fetchAllTimetable(): LiveData<Timetable> {

        compositeDisposable.add(
            ApiUtils.apiService.getTimetable(class_id = "1", section_id = "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        getAllTimetable.value = it
                    }
                ))
        return getAllTimetable
    }

}