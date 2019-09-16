package com.selwan.schools365teacher.ui.attendance.student.rec

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.attendance.AttendanceMsg
import com.selwan.schools365teacher.data.model.attendance.Attendencetypeslist
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.data.model.attendance.StudentSession
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class AttendanceStudentRecRepository(var compositeDisposable: CompositeDisposable) {

    var studentAttendance = MutableLiveData<StudentAttendance>()
    var attendencetypeslist = MutableLiveData<Attendencetypeslist>()
    var attendanceMsg = MutableLiveData<AttendanceMsg>()

    //AttendanceStudentMainFragment.class_id!!,
    //                AttendanceStudentMainFragment.section_id!!
    fun fetchStudentAttendance(): MutableLiveData<StudentAttendance> {
        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentAttendance(
                "1", "1"
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {

                        studentAttendance.value = it
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