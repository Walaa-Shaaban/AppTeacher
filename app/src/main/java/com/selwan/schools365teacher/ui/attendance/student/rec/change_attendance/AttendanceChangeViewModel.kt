package com.selwan.schools365teacher.ui.attendance.student.rec.change_attendance

import android.util.Log
import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.data.model.attendance.StudentSession
import io.reactivex.disposables.CompositeDisposable

class AttendanceChangeViewModel(
    class_id: String,
    section_id: String,
    date: String,
    isHoliday: Boolean,
    studentSession: List<StudentSession>
) : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var attendanceChangeRepository: AttendanceChangeRepository

    init {
        compositeDisposable = CompositeDisposable()
        attendanceChangeRepository = AttendanceChangeRepository(compositeDisposable)
        attendanceChangeRepository.getAllAttendanceType()
    }

    val getAttendanceType by lazy {
        attendanceChangeRepository.attendanceTypeList
    }

    val saveChangeAttendance by lazy {

        Log.e(
            "###",
            "${class_id}, ${section_id}, ${date}, ${isHoliday}, ${studentSession.get(0).attendence_type_id}"
        )
        attendanceChangeRepository.saveNewAttendance(
            class_id,
            section_id,
            date,
            isHoliday,
            studentSession
        )
    }


}
