package com.selwan.schools365teacher.ui.student_details.recyclerview_student_details


import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.student_details.StudentsDetailsFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
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

        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentInSection(StudentsDetailsFragment.class_id!!, StudentsDetailsFragment.section_id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        allStudentinSection.value = it
                    }, Consumer {
                        val snackbar =
                            Snackbar.make(
                                view!!,
                                "Something Went Error ... The data couldn't be read",
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                ))
        return allStudentinSection
    }




}