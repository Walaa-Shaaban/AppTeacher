package com.selwan.schools365teacher.ui.event.rec

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AllEventViewModel(var start_date: String) : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var allEventRepository: AllEventRepository

    init {
        compositeDisposable = CompositeDisposable()
        allEventRepository = AllEventRepository(compositeDisposable, start_date)
        allEventRepository.fetchAllEvent()
    }

    val allEvent by lazy { allEventRepository.allEventInDate }
}
