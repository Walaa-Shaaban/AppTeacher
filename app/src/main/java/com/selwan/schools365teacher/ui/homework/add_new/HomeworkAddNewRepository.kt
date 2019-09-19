package com.selwan.schools365teacher.ui.homework.add_new

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.homework.AddNewHomework
import com.selwan.schools365teacher.data.model.homework.Subject
import com.selwan.schools365teacher.data.model.student_details.Classes
import com.selwan.schools365teacher.data.model.student_details.Sections
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomeworkAddNewRepository(var compositeDisposable: CompositeDisposable) {

    var homeworks = MutableLiveData<AddNewHomework>()
    var classes: MutableLiveData<List<Classes>>
    var sections: MutableLiveData<List<Sections>>
    var subject = MutableLiveData<List<Subject>>()

    init {
        classes = MutableLiveData()
        sections = MutableLiveData()

    }


    fun addNewHomework(
        class_id: String,
        section_id: String,
        subject_id: String,
        homework_date: String,
        submit_date: String,
        description: String
    ): LiveData<AddNewHomework> {
        compositeDisposable.add(
            ApiUtils.apiService.add_homework(
                class_id,
                section_id,
                subject_id,
                homework_date,
                submit_date,
                description
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        homeworks.value = it
                    }
                ))

        return homeworks
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
            ApiUtils.apiService.getSections(class_id = HomeworkAddNewFragment.class_id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        sections.value = it
                    }
                ))
        return sections
    }

    fun fetchSubject(
        compositeDisposable: CompositeDisposable
    ): LiveData<List<Subject>> {
        compositeDisposable.add(
            ApiUtils.apiService.getSubject(
                class_id = HomeworkAddNewFragment.class_id!!,
                section_id = HomeworkAddNewFragment.section_id!!
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        subject.value = it
                    }
                ))
        return subject
    }
}