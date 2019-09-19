package com.selwan.schools365teacher.ui.examination.view_mark

import android.content.Context
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class ExaminationViewMarkViewHolder(
    context: Context,
    class_id: String,
    section_id: String,
    exam_id: String
) : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var examinationViewMarkRepository: ExaminationViewMarkRepository

    init {
        compositeDisposable = CompositeDisposable()
        examinationViewMarkRepository = ExaminationViewMarkRepository(compositeDisposable, context)
    }

    val getAllViewMark by lazy {
        examinationViewMarkRepository.fetchAddViewMark(
            exam_id = exam_id,
            section_id = section_id,
            class_id = class_id
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }


}