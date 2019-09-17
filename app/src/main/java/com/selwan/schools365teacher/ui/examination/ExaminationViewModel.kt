package com.selwan.schools365teacher.ui.examination

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class ExaminationViewModel : ViewModel() {

    var examinationRepository: ExaminationRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        examinationRepository = ExaminationRepository(compositeDisposable)
        examinationRepository.fetchAllExams()

    }

    val fetchAllExams by lazy {
        examinationRepository.allExams
    }
}
