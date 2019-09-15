package com.selwan.schools365teacher.ui.communication.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class CommunicationNoticBoardViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var communicationNoticBoardRepository: CommunicationNoticBoardRepository

    init {
        compositeDisposable = CompositeDisposable()
        communicationNoticBoardRepository = CommunicationNoticBoardRepository(compositeDisposable)
    }

    val getNoticBoard by lazy {
        communicationNoticBoardRepository.fetchAllNoticBoard()
    }
}
