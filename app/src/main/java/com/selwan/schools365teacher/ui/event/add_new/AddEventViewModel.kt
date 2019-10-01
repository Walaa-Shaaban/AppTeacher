package com.selwan.schools365teacher.ui.event.add_new

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class AddEventViewModel(
    title: String,
    description: String,
    endTime: String,
    startDate: String,
    eventType: String
) : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var addEventRepository: AddEventRepository

    init {
        compositeDisposable = CompositeDisposable()
        addEventRepository = AddEventRepository(compositeDisposable)
        addEventRepository.PostAddEvent(
            title = title,
            description = description,
            endTime = endTime,
            eventType = eventType,
            startDate = startDate
        )
    }

    val postAddEvent by lazy {
        addEventRepository.addEvent
    }

}
