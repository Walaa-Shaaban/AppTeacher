package com.selwan.schools365teacher.ui.homework.AllHomework

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AllHomeworkViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var homeworkMainRepository: AllHomeworkRepository

    init {
        compositeDisposable = CompositeDisposable()
        homeworkMainRepository =
            AllHomeworkRepository(compositeDisposable)
    }

    val getHomeworkList by lazy {
        homeworkMainRepository.fetchAllHomework()
    }
}
