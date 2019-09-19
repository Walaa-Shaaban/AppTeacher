package com.selwan.schools365teacher.ui.examination.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class ExaminationMainViewModel : ViewModel() {

    lateinit var compositeDisposable: CompositeDisposable
    var examinationMainRepository: ExaminationMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        examinationMainRepository = ExaminationMainRepository()
    }

    val getAllClasses by lazy {
        examinationMainRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        examinationMainRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
