package com.selwan.schools365teacher.ui.examination.tabs

import android.content.Context
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class ExaminationViewModel(context: Context) : ViewModel() {

    var examinationRepository: ExaminationRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        examinationRepository =
            ExaminationRepository(
                compositeDisposable, context
            )
        examinationRepository.fetchAllExams()

    }

    val fetchAllExams by lazy {
        examinationRepository.allExams
    }
}
