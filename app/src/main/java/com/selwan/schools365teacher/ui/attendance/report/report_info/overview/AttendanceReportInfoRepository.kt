package com.selwan.schools365teacher.ui.attendance.report.report_info.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.attendance.AttendanceReport
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AttendanceReportInfoRepository(var compositeDisposable: CompositeDisposable) {

    var studentReportInfo = MutableLiveData<AttendanceReport>()

    fun fetchAttendenceStudentReportInfo(
        class_id: String,
        section_id: String,
        year: String,
        month: String
    )
            : LiveData<AttendanceReport> {

        compositeDisposable.add(
            ApiUtils.apiService.getAllReportByMonth(class_id, section_id, year, month)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        studentReportInfo.value = it
                    }
                ))
        return studentReportInfo
    }
}
