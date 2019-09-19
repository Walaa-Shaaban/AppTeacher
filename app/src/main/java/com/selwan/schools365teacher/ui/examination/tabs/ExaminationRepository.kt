package com.selwan.schools365teacher.ui.examination.tabs

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
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
                    Toast.makeText(
                        context,
                        "Something Went Error ... The data couldn't be read",
                        Toast.LENGTH_LONG
                    ).show()
                })
        )

        return allExams
    }
}