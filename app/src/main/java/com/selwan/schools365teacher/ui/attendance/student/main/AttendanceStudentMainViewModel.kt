package com.selwan.schools365teacher.ui.attendance.student.main

import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.ui.attendance.date.main.AttendenceDateMainRepository
import io.reactivex.disposables.CompositeDisposable

class AttendanceStudentMainViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var attendenceStudentMainRepository: AttendanceStudentMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        attendenceStudentMainRepository = AttendanceStudentMainRepository()
    }

    val getAllClasses by lazy {
        attendenceStudentMainRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        attendenceStudentMainRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
