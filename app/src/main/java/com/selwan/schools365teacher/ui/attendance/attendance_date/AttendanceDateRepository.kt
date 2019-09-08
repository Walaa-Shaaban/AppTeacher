package com.selwan.schools365teacher.ui.attendance.attendance_date

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.attendance.AttendanceByDate
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.attendance.attendance_student.student_attendence.AttendanceStudentFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AttendanceDateRepository(var compositeDisposable: CompositeDisposable) {

    var getAllStudentAttendanceByDate : MutableLiveData<AttendanceByDate>

    init {
        getAllStudentAttendanceByDate = MutableLiveData<AttendanceByDate>()
    }

    fun fetchAllStudentAttendanceByDate(class_id: String, section_id: String, date: String)
    :LiveData<AttendanceByDate> {

        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentAttendanceByDate(class_id, section_id, date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        Log.e("~~~~", "")
                        getAllStudentAttendanceByDate.value = it
                    }
                ))

        return getAllStudentAttendanceByDate
    }
}