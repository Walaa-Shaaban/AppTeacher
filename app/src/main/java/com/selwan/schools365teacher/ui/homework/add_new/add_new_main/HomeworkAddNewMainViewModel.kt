package com.selwan.schools365teacher.ui.homework.add_new.add_new_main

import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.ui.examination.main.ExaminationMainRepository
import io.reactivex.disposables.CompositeDisposable

class HomeworkAddNewMainViewModel : ViewModel() {

    lateinit var compositeDisposable: CompositeDisposable
    var homeworkAddNewMainRepository = HomeworkAddNewMainRepository()

    init {
        compositeDisposable = CompositeDisposable()
        homeworkAddNewMainRepository = HomeworkAddNewMainRepository()
    }

    val getAllClasses by lazy {
        homeworkAddNewMainRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        homeworkAddNewMainRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
