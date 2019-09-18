package com.selwan.schools365teacher.ui.examination.add_new_exam

import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew
import io.reactivex.disposables.CompositeDisposable

class AddNewExamViewModel(
    class_id: String,
    section_id: String,
    exam_id: String,
    listExam: List<ExamScheduleAddNew>
) : ViewModel() {

    var addNewExamRepository: AddNewExamRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        addNewExamRepository = AddNewExamRepository(compositeDisposable)
        addNewExamRepository.addNewExam(
            class_id = class_id,
            section_id = section_id,
            listExam = listExam,
            exam_id = exam_id
        )
    }

    val AddNewExam by lazy {
        addNewExamRepository.getDataAddNewExam
    }
}
