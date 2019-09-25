package com.selwan.schools365teacher.ui.attendance.student.rec.AllStudentAttendance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.attendance.AttendanceMsg
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.data.model.attendance.StudentSession
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.attendance.student.main.AttendanceStudentMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class AttendanceStudentRecRepository(var compositeDisposable: CompositeDisposable) {

    var studentAttendance = MutableLiveData<StudentAttendance>()
    var attendanceMsg = MutableLiveData<AttendanceMsg>()


    fun fetchStudentAttendance(): MutableLiveData<StudentAttendance> {
        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentAttendance(
                AttendanceStudentMainFragment.class_id!!, AttendanceStudentMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        studentAttendance.value = it
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
        return studentAttendance
    }

    /*
    fun fetchAttendenceType(attendence_id: String): MutableLiveData<Attendencetypeslist> {
        compositeDisposable.add(
            ApiUtils.apiService.getAllAttendanceTypeList(
                AttendanceStudentMainFragment.class_id!!,
                AttendanceStudentMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        for (type in it) {
                            if (type.id.equals(attendence_id)) {
                                attendencetypeslist.value = type
                            }
                        }
                    }
                )
        )

        return attendencetypeslist
    }

     */

    fun changeAttendanceType(
        class_id: String,
        section_id: String,
        date: String,
        is_holiday: Boolean,
        attendance_session: List<StudentSession>
    ): LiveData<AttendanceMsg> {
        compositeDisposable.add(
            ApiUtils.apiService.attendanceSave(
                class_id, section_id, date, is_holiday, attendance_session
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {

                        attendanceMsg.value = it
                    }
                )
        )
        return attendanceMsg
    }


}