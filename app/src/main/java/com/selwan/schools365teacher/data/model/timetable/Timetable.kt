package com.selwan.schools365teacher.data.model.timetable

data class Timetable(
    val class_id: String,
    val section_id: String,
    val getDaysnameList: GetDaysnameList,
    val result_array: List<ResultArray>
)