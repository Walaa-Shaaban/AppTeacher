package com.selwan.schools365teacher.data.model.attendance

data class AttendanceInfo(
    val absent: String,
    val half_day: String,
    val holiday: String,
    val late: String,
    val late_with_excuse: String,
    val present: String
)