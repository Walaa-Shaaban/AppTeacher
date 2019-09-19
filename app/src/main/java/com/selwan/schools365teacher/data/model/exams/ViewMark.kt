package com.selwan.schools365teacher.data.model.exams

data class ViewMark(
    val class_id: String,
    val examSchedule: ExamScheduleX,
    val exam_id: String,
    val section_id: String
)