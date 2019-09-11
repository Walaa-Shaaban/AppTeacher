package com.selwan.schools365teacher.ui.timetable.tabs_day.ui.main


import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class TimetableTabsViewModel : ViewModel() {

    val compositeDisposable: CompositeDisposable
    val timetableTabsRepository: TimetableTabsRepository

    init {
        compositeDisposable = CompositeDisposable()
        timetableTabsRepository = TimetableTabsRepository(compositeDisposable)
        timetableTabsRepository.fetchAllTimetable()
    }

    val getTimetable by lazy {
        timetableTabsRepository.getAllTimetable
    }

}