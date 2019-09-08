package com.selwan.schools365teacher.ui.student_details.student_details_info


import androidx.lifecycle.MutableLiveData
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.utils.ApiUtils
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
                    }
                ))

        return studentDetails
    }



}