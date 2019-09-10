package com.selwan.schools365teacher.ui.attendance.student.main

import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.ui.attendance.date.main.AttendenceDateMainRepository
import io.reactivex.disposables.CompositeDisposable

class AttendanceStudentMainViewModel : ViewModel() {

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
