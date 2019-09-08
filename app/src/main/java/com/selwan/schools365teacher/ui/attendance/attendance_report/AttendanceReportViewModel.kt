package com.selwan.schools365teacher.ui.attendance.attendance_report

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceReportViewModel : ViewModel() {

    var attendanceReportRepository: AttendanceReportRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        attendanceReportRepository = AttendanceReportRepository(compositeDisposable)
    }
    //class_id. section_id, year, month class_id=1&section_id=1&year=2019&month=August
    val getAllStudenAttendanceByReport by lazy {
        attendanceReportRepository.fetchAllStudentReport("1", "1", "2019", "August")
    }
}
