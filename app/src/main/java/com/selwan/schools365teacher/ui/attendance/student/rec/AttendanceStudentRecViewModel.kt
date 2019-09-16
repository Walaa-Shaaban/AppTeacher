package com.selwan.schools365teacher.ui.attendance.student.rec

import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.data.model.attendance.StudentSession
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


    fun saveAttendance(
        class_id: String,
        section_id: String,
        date: String,
        is_holiday: Boolean,
        attendance_session: List<StudentSession>
    ) {
        attendanceStudentRepository.changeAttendanceType(
            class_id,
            section_id,
            date,
            is_holiday,
            attendance_session
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
