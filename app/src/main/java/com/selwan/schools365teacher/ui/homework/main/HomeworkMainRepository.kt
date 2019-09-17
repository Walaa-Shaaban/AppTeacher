package com.selwan.schools365teacher.ui.homework.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.homework.HomeworkList
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomeworkMainRepository(var compositeDisposable: CompositeDisposable) {

    var homeworks = MutableLiveData<HomeworkList>()

    fun fetchAllHomework(): LiveData<HomeworkList> {
        compositeDisposable.add(
            ApiUtils.apiService.getHomeworkList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        homeworks.value = it
                    }
                ))

        return homeworks
    }
}
