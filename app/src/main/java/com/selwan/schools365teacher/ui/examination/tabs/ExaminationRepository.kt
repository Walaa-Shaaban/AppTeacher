package com.selwan.schools365teacher.ui.examination.tabs

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class ExaminationRepository(var compositeDisposable: CompositeDisposable, var context: Context) {

    var allExams = MutableLiveData<AllExamSchedule>()
    fun fetchAllExams(): LiveData<AllExamSchedule> {
        compositeDisposable.add(
            ApiUtils.apiService.getAllExams(
                ExaminationMainFragment.class_id!!,
                ExaminationMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    allExams.value = it

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
                })
        )

        return allExams
    }
}