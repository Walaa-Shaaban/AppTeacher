package com.selwan.schools365teacher.ui.attendance.report.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceReportMainViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var attendanceReportMainRepository: AttendanceReportMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        attendanceReportMainRepository = AttendanceReportMainRepository(compositeDisposable)
    }

    val getAllClasses by lazy {
        attendanceReportMainRepository.fetchAllClasses(compositeDisposable)
    }
    val getAllSection by lazy {
        attendanceReportMainRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
