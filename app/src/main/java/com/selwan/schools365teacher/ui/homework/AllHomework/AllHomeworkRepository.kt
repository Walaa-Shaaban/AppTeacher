package com.selwan.schools365teacher.ui.homework.AllHomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.homework.HomeworkList
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AllHomeworkRepository(var compositeDisposable: CompositeDisposable) {

    var homeworks = MutableLiveData<HomeworkList>()

    fun fetchAllHomework(): LiveData<HomeworkList> {
        compositeDisposable.add(
            ApiUtils.apiService.getHomeworkList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        homeworks.value = it
                    }, Consumer {
                        val snackbar =
                            view?.let { it1 ->
                                Snackbar.make(
                                    it1,
                                    "Something Went Error ... The data couldn't be read",
                                    Snackbar.LENGTH_LONG
                                )
                            }
                        val sbView = snackbar!!.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                ))

        return homeworks
    }
}
