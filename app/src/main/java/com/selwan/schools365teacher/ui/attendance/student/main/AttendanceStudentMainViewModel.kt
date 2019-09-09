package com.selwan.schools365teacher.ui.attendance.student.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceStudentMainViewModel : ViewModel() {

    lateinit var compositeDisposable: CompositeDisposable
    var attendenceStudentRepository: AttendenceStudentMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        attendenceStudentRepository = AttendenceStudentMainRepository()
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
