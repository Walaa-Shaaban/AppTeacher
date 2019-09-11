package com.selwan.schools365teacher.ui.timetable.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.student_details.Classes
import com.selwan.schools365teacher.data.model.student_details.Sections
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.attendance.date.main.AttendanceDateMainFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class TimetableMainRepository {

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