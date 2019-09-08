package com.selwan.schools365teacher.ui.student_details

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class StudentsDetailsViewModel() : ViewModel() {

    lateinit var compositeDisposable: CompositeDisposable
    var studentsDetailsRepository: StudentsDetailsRepository

    init {
        compositeDisposable = CompositeDisposable()
        studentsDetailsRepository = StudentsDetailsRepository()
    }

    val getAllClasses by lazy {
        studentsDetailsRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        studentsDetailsRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
