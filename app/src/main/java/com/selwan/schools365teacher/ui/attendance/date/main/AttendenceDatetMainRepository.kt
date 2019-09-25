package com.selwan.schools365teacher.ui.attendance.date.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.student_details.Classes
import com.selwan.schools365teacher.data.model.student_details.Sections
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class AttendenceDateMainRepository {

    var classes: MutableLiveData<List<Classes>>
    var sections: MutableLiveData<List<Sections>>

    init {
        classes = MutableLiveData()
        sections = MutableLiveData()
    }


    fun fetchAllClasses(compositeDisposable: CompositeDisposable): LiveData<List<Classes>> {
        compositeDisposable.add(
            ApiUtils.apiService.getClasses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        classes.value = it
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
        return classes
    }

    fun fetchAllSectionUsingClassId(
        compositeDisposable: CompositeDisposable
    ): LiveData<List<Sections>> {

        compositeDisposable.add(
            ApiUtils.apiService.getSections(class_id = AttendanceDateMainFragment.class_id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        sections.value = it
                    }
                ))
        return sections
    }


}
