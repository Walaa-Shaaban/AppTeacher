package com.selwan.schools365teacher.ui.student_details.recyclerview_student_details


import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class RecyclerviewRepositoryDetails{

    var compositeDisposable: CompositeDisposable
    var allStudentinSection: MutableLiveData<List<StudentDetails>>


    init {
        compositeDisposable = CompositeDisposable()
        allStudentinSection = MutableLiveData<List<StudentDetails>>()
    }

    fun getAllStudentInSection(): MutableLiveData<List<StudentDetails>> {


        /*
        StudentsDetailsFragment.class_id!!, StudentsDetailsFragment.section_id!!
         */

        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentInSection(StudentsDetailsFragment.class_id!!, StudentsDetailsFragment.section_id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        allStudentinSection.value = it

                    }
                ))
        return allStudentinSection
    }




}