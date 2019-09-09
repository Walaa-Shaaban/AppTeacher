package com.selwan.schools365teacher.ui.attendance.report.report_info.overview

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceReportInfoViewModel : ViewModel() {
    lateinit var attendanceReportInfoRepository: AttendanceReportInfoRepository
    lateinit var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        attendanceReportInfoRepository = AttendanceReportInfoRepository(compositeDisposable)
    }


    val studentReportInfo by lazy {
        attendanceReportInfoRepository.fetchAttendenceStudentReportInfo("1", "1", "2019", "August")
    }
}
