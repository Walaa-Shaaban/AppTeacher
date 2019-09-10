package com.selwan.schools365teacher.ui.attendance.student.rec

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceStudentRecViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var attendanceStudentRepository : AttendanceStudentRecRepository


    init {
        compositeDisposable = CompositeDisposable()
        attendanceStudentRepository =
            AttendanceStudentRecRepository(
                compositeDisposable
            )
    }

    val getStudentAttendance by lazy {
        attendanceStudentRepository.fetchStudentAttendance()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
