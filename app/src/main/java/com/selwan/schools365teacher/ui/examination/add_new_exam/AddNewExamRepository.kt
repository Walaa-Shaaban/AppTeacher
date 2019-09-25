package com.selwan.schools365teacher.ui.examination.add_new_exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew
import com.selwan.schools365teacher.data.model.exams.ResultAddNewExam
import com.selwan.schools365teacher.data.model.homework.Subject
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AddNewExamRepository(var compositeDisposable: CompositeDisposable) {

    var getDataAddNewExam = MutableLiveData<ResultAddNewExam>()
    var getSubject = MutableLiveData<List<Subject>>()

    fun addNewExam(
        class_id: String,
        section_id: String,
        exam_id: String,
        listExam: List<ExamScheduleAddNew>
    ): LiveData<ResultAddNewExam> {
        compositeDisposable.add(
            ApiUtils.apiService.addNewExam(
                class_id = class_id,
                section_id = section_id,
                exam_id = exam_id,
                examSchedule = listExam
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        getDataAddNewExam.value = it
                    }
                ))
        return getDataAddNewExam
    }


    //AddSubject
    fun fetchSubject(
        compositeDisposable: CompositeDisposable
    ): LiveData<List<Subject>> {
        compositeDisposable.add(
            ApiUtils.apiService.getSubject(
                ExaminationMainFragment.class_id!!,
                ExaminationMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        getSubject.value = it
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
                ))
        return getSubject
    }
}