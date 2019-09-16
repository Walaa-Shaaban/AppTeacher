package com.selwan.schools365teacher.data.model.attendance

data class AttendanceSave(
    val class_id: Int,
    val date: String,
    val holiday: Boolean,
    val section_id: Int,
    val student_session: List<StudentSession>
)