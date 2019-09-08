package com.selwan.schools365teacher.ui.attendance.attendance_student.student_attendence

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AttendanceStudentViewModel : ViewModel() {

    lateinit var compositeDisposable: CompositeDisposable
    var attendenceStudentRepository: AttendenceStudentRepository

    init {
        compositeDisposable = CompositeDisposable()
        attendenceStudentRepository = AttendenceStudentRepository()
    }

    val getAllClasses by lazy {
        attendenceStudentRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        attendenceStudentRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
