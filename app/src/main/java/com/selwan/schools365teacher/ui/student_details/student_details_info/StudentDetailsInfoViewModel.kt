package com.selwan.schools365teacher.ui.student_details.student_details_info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.selwan.schools365teacher.data.model.student_details.StudentDetails

class StudentDetailsInfoViewModel(student_id: String) : ViewModel() {

    var studentDetails : MutableLiveData<List<StudentDetails>>
    var studentDetailsInfoRepository: StudentDetailsInfoRepository

    init {
        studentDetails = MutableLiveData<List<StudentDetails>>()
        studentDetailsInfoRepository = StudentDetailsInfoRepository()
    }

    val getStudentDetailsInfo by lazy {
        studentDetailsInfoRepository.fetchStudentDetails(student_id)
    }

}
