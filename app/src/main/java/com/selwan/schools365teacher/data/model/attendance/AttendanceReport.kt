package com.selwan.schools365teacher.data.model.attendance

data class AttendanceReport(
    val attendence_array: List<String>,
    val class_id: String,
    val monthAttendance: List<MonthAttendance>,
    val month_selected: String,
    val no_of_days: Int,
    val resultlist: Resultlist,
    val section_id: String,
    val student_array: List<StudentArray>,
    val year_selected: String
)