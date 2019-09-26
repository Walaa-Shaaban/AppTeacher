package com.selwan.schools365teacher.ui.attendance.student.rec.change_attendance

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.*
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.attendance.student.main.AttendanceStudentMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AttendanceChangeRepository(var compositeDisposable: CompositeDisposable) {

    var attendanceTypeList = MutableLiveData<StudentAttendance>()
    var attendanceMsg = MutableLiveData<AttendanceMsg>()

    fun getAllAttendanceType(): LiveData<StudentAttendance> {
        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentAttendance(
                AttendanceStudentMainFragment.class_id!!, AttendanceStudentMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        attendanceTypeList.value = it
                    }, Consumer {
                        val snackbar =
                            Snackbar.make(
                                view!!,
                                "Something Went Error ... The data couldn't be read",
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                )
        )
        return attendanceTypeList
    }


    fun saveNewAttendance(
        class_id: String,
        section_id: String,
        date: String,
        isHoliday: Boolean,
        studentSession: List<StudentSession>
    ): LiveData<AttendanceMsg> {
        compositeDisposable.add(
            ApiUtils.apiService.attendanceSave(
                class_id = class_id,
                section_id = section_id,
                date = "2019-09-24",
                holiday = isHoliday,
                studentSession = studentSession
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        attendanceMsg.value = it
                    }, Consumer {
                        val snackbar =
                            Snackbar.make(
                                view!!,
                                "Something Went Error ... The data couldn't be read",
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                )
        )
        return attendanceMsg
    }
}