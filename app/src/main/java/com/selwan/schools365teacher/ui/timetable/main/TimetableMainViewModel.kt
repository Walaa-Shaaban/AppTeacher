package com.selwan.schools365teacher.ui.timetable.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class TimetableMainViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var timetableMainRepository: TimetableMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        timetableMainRepository = TimetableMainRepository()
    }

    val getAllClasses by lazy {
        timetableMainRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        timetableMainRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
