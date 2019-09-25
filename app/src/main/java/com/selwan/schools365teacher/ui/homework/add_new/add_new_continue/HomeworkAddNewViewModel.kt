package com.selwan.schools365teacher.ui.homework.add_new.add_new_continue

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.data.model.homework.AddNewHomework
import io.reactivex.disposables.CompositeDisposable

class HomeworkAddNewViewModel : ViewModel() {

    var compositeDisposable: CompositeDisposable
    var homeworkAddNewRepository: HomeworkAddNewRepository

    init {
        compositeDisposable = CompositeDisposable()
        homeworkAddNewRepository =
            HomeworkAddNewRepository(
                compositeDisposable
            )
    }

    fun addHomework(
        class_id: String,
        section_id: String,
        subject_id: String,
        homework_date: String,
        submit_date: String,
        message: String
    ): LiveData<AddNewHomework> {
        return homeworkAddNewRepository.addNewHomework(
            class_id,
            section_id,
            subject_id,
            homework_date,
            submit_date,
            message
        )

    }

    val getSubject by lazy {
        homeworkAddNewRepository.fetchSubject(compositeDisposable)
    }


    val getAllClasses by lazy {
        homeworkAddNewRepository.fetchAllClasses(compositeDisposable)
    }

    val getAllSections by lazy {
        homeworkAddNewRepository.fetchAllSectionUsingClassId(compositeDisposable)
    }
}
