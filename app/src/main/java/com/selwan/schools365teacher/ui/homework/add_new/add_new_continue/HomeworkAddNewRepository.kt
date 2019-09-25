package com.selwan.schools365teacher.ui.homework.add_new.add_new_continue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.homework.AddNewHomework
import com.selwan.schools365teacher.data.model.homework.Subject
import com.selwan.schools365teacher.data.model.student_details.Classes
import com.selwan.schools365teacher.data.model.student_details.Sections
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainFragment
import com.selwan.schools365teacher.ui.homework.add_new.add_new_main.HomeworkAddNewMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
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
            ApiUtils.apiService.getSections(class_id = HomeworkAddNewMainFragment.class_id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        sections.value = it
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
        return sections
    }


    //AddSubject
    fun fetchSubject(
        compositeDisposable: CompositeDisposable
    ): LiveData<List<Subject>> {
        compositeDisposable.add(
            ApiUtils.apiService.getSubject(
                HomeworkAddNewMainFragment.class_id!!,
                HomeworkAddNewMainFragment.section_id!!
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        subject.value = it
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
        return subject
    }

}