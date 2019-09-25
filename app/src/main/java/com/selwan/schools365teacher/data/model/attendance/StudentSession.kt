package com.selwan.schools365teacher.data.model.attendance

data class StudentSession(
    val attendence_id: Int,
    val attendence_type_id: Int,
    val attendences_other_notes: Int,
    val remark: String,
    val student_session_id: Int
)