package com.selwan.schools365teacher.ui.attendance.date.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceDateMainViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var attendenceStudentRepository: AttendenceDateMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        attendenceStudentRepository = AttendenceDateMainRepository()
    }

    val getAllClasses by lazy {
        attendenceStudentRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        attendenceStudentRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
