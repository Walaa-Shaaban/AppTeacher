package com.selwan.schools365teacher.ui.communication.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.communication.NoticBoard
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class CommunicationNoticBoardRepository(var compositeDisposable: CompositeDisposable) {

    var noticBoard = MutableLiveData<NoticBoard>()

    fun fetchAllNoticBoard(): LiveData<NoticBoard> {
        compositeDisposable.add(
            ApiUtils.apiService.getNoticBoard()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        noticBoard.value = it
                    }
                ))

        return noticBoard
    }
}