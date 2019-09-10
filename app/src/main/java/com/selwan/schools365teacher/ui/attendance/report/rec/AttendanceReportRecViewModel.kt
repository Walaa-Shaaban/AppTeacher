package com.selwan.schools365teacher.ui.attendance.report.rec

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceReportRecViewModel(
    class_id: String,
    section_id: String,
    year: String,
    month: String
) : ViewModel() {

    var attendanceReportRepository: AttendanceReportRecRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        attendanceReportRepository =
            AttendanceReportRecRepository(
                compositeDisposable
            )
    }

    val getAllStudenAttendanceByReport by lazy {
        attendanceReportRepository.fetchAllStudentReport(class_id, section_id, year, month)
    }
}
