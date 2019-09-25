package com.selwan.schools365teacher.ui.news.news_details

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class NewsDetailsViewModel : ViewModel() {

    var newsRepository: NewsDetailsRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        newsRepository =
            NewsDetailsRepository(compositeDisposable)
        newsRepository.fetchAllNews()
    }

    val getNews by lazy {
        newsRepository.allNews
    }
}
