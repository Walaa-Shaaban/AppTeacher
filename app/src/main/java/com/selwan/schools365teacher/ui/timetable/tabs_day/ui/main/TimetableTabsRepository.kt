package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.timetable.Timetable
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
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
            ApiUtils.apiService.getTimetable(
                class_id = TimetableMainFragment.class_id!!,
                section_id = TimetableMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        getAllTimetable.value = it
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
        return getAllTimetable
    }

}