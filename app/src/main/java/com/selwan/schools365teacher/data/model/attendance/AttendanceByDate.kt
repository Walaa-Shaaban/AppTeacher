package com.selwan.schools365teacher.data.model.attendance

data class AttendanceByDate(
    val attendencetypeslist: List<Attendencetypeslist>,
    val class_id: String,
    val date: String,
    val resultlist: List<Resultlist>,
    val section_id: String
)