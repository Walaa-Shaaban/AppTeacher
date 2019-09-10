package com.selwan.schools365teacher.ui.attendance.date.rec

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceDateRecViewModel(var class_id: String, var section_id: String, var date: String) :
    ViewModel() {

    var attendanceDateRepository: AttendanceDateRecRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        attendanceDateRepository =
            AttendanceDateRecRepository(
                compositeDisposable
            )
        attendanceDateRepository.fetchAllStudentAttendanceByDate(
            class_id = class_id,
            section_id = section_id,
            date = date
        )
    }

    val getAllStudentAttendanceByDate by lazy {
        attendanceDateRepository.getAllStudentAttendanceByDate
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
