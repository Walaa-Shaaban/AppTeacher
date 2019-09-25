package com.selwan.schools365teacher.ui.student_details.student_details_info


import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class StudentDetailsInfoRepository {

    var compositeDisposable: CompositeDisposable
    var studentDetails : MutableLiveData<StudentDetails>

    init{
        compositeDisposable = CompositeDisposable()
        studentDetails = MutableLiveData<StudentDetails>()
    }

    //StudentsDetailsFragment.class_id!!, StudentsDetailsFragment.section_id!!
    fun fetchStudentDetails( student_id: String):MutableLiveData<StudentDetails>{

        compositeDisposable.add(
            ApiUtils.apiService.getAllStudentInSection("1", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    Consumer {
                        for (student in it ){
                            if (student.id == student_id){
                                studentDetails.value = student
                            }
                        }
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

        return studentDetails
    }



}