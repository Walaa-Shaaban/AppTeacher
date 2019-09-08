package com.selwan.schools365teacher.ui.student_details.recyclerview_student_details

import androidx.lifecycle.ViewModel

class RecyclerviewDetailsViewmodel() : ViewModel() {


    var recyclerviewRepositoryDetails: RecyclerviewRepositoryDetails


    init {
        this.recyclerviewRepositoryDetails = RecyclerviewRepositoryDetails()
        recyclerviewRepositoryDetails.getAllStudentInSection()
    }

    val allStudentinSection by lazy {
        recyclerviewRepositoryDetails.allStudentinSection
    }


}