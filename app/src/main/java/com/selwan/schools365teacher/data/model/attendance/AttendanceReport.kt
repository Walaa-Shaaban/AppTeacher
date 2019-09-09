package com.selwan.schools365teacher.data.model.attendance

data class AttendanceReport(
    val attendence_array: List<String>,
    val class_id: String,
    val monthAttendance: List<HashMap<String, AttendanceInfo>>,
    val month_selected: String,
    val no_of_days: Int,
    val resultlist: HashMap<String, HashMap<String, StudentArray>>,
    val section_id: String,
    val student_array: List<StudentArray>,
    val year_selected: String
)