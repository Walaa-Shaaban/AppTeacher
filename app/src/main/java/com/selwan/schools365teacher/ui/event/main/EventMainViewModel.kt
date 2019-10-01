package com.selwan.schools365teacher.ui.event.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class EventMainViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var eventMainRepository: EventMainRepository

    init {
        compositeDisposable = CompositeDisposable()
        eventMainRepository = EventMainRepository(compositeDisposable)
        eventMainRepository.fetchAllEvent()
    }

    val allEvent by lazy { eventMainRepository.allEvent }
}



