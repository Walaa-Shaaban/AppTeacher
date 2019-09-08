package com.selwan.schools365teacher.ui.attendance.attendance_date

import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.ui.attendance.attendance_student.student_attendence.AttendanceStudentFragment
import io.reactivex.disposables.CompositeDisposable

class AttendanceDateViewModel : ViewModel() {

    var attendanceDateRepository: AttendanceDateRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        attendanceDateRepository = AttendanceDateRepository(compositeDisposable)
        attendanceDateRepository.fetchAllStudentAttendanceByDate("1", "1", "09/8/2019")
    }

    val getAllStudentAttendanceByDate by lazy {
        attendanceDateRepository.getAllStudentAttendanceByDate
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
