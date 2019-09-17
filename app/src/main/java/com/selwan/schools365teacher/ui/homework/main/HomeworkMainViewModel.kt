package com.selwan.schools365teacher.ui.homework.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class HomeworkMainViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var homeworkMainRepository: HomeworkMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        homeworkMainRepository =
            HomeworkMainRepository(compositeDisposable)
    }

    val getHomeworkList by lazy {
        homeworkMainRepository.fetchAllHomework()
    }
}
