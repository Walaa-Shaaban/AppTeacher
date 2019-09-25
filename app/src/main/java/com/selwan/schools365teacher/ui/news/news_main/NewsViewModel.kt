package com.selwan.schools365teacher.ui.news.news_main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class NewsViewModel : ViewModel() {
    var newsRepository: NewsRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        newsRepository =
            NewsRepository(compositeDisposable)
        newsRepository.fetchAllNews()
    }


    val getNews by lazy {
        newsRepository.allNews
    }
}
