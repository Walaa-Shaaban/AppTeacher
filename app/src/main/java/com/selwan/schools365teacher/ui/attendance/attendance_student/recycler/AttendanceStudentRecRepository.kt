package com.selwan.schools365teacher.ui.attendance.attendance_student.recycler

import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.attendance.Attendencetypeslist
import com.selwan.schools365teacher.data.model.attendance.Resultlist
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.attendance.AttendanceFragment
import com.selwan.schools365teacher.ui.attendance.attendance_student.student_attendence.AttendanceStudentFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class AttendanceStudentRecRepository(var compositeDisposable: CompositeDisposable) {

    var studentAttendance = MutableLiveData<List<Resultlist>>()
    var attendencetypeslist = MutableLiveData<Attendencetypeslist>()

    //AttendanceStudentFragment.class_id!!,
    //                AttendanceStudentFragment.section_id!!
    fun fetchStudentAttendance(): MutableLiveData<List<Resultlist>> {
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
                AttendanceStudentFragment.class_id!!,
                AttendanceStudentFragment.section_id!!
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


}