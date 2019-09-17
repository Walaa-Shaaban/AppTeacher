package com.selwan.schools365teacher.ui.examination

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class ExaminationRepository(var compositeDisposable: CompositeDisposable) {

    var allExams = MutableLiveData<AllExamSchedule>()
    fun fetchAllExams(): LiveData<AllExamSchedule> {
        compositeDisposable.add(
            ApiUtils.apiService.getAllExams()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        allExams.value = it
                    }
                ))

        return allExams
    }
}