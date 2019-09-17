package com.selwan.schools365teacher.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.news.News
import com.selwan.schools365teacher.data.utils.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class NewsRepository(var compositeDisposable: CompositeDisposable) {

    var allNews = MutableLiveData<News>()
    fun fetchAllNews(): LiveData<News> {

        compositeDisposable.add(
            ApiUtils.apiService.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        allNews.value = it
                    }
                ))
        return allNews
    }

}