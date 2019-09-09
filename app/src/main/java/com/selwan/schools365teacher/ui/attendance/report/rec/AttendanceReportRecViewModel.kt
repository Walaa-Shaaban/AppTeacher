package com.selwan.schools365teacher.ui.attendance.report.rec

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceReportRecViewModel : ViewModel() {

    var attendanceReportRepository: AttendanceReportRecRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        attendanceReportRepository =
            AttendanceReportRecRepository(
                compositeDisposable
            )
    }
    //class_id. section_id, year, month class_id=1&section_id=1&year=2019&month=August
    val getAllStudenAttendanceByReport by lazy {
        attendanceReportRepository.fetchAllStudentReport("1", "1", "2019", "August")
    }
}
