package com.selwan.schools365teacher.ui.examination.add_new_exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew
import com.selwan.schools365teacher.data.model.exams.ResultAddNewExam
import io.reactivex.disposables.CompositeDisposable

class AddNewExamViewModel(
    var class_id: String,
    var section_id: String,
    var exam_id: String,
    var listExam: List<ExamScheduleAddNew>
) : ViewModel() {

    var addNewExamRepository: AddNewExamRepository
    var compositeDisposable: CompositeDisposable

    init {
        compositeDisposable = CompositeDisposable()
        addNewExamRepository = AddNewExamRepository(compositeDisposable)

    }

    fun addNewExamByTeacher(): LiveData<ResultAddNewExam> {
        return addNewExamRepository.addNewExam(
            class_id = class_id,
            section_id = section_id,
            listExam = listExam,
            exam_id = exam_id
        )
    }


    val getSubject by lazy {
        addNewExamRepository.fetchSubject(compositeDisposable)
    }
}
