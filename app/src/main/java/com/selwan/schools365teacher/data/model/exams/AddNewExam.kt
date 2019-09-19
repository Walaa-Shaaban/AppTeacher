package com.selwan.schools365teacher.data.model.exams

data class AddNewExam(
    val class_id: Int,
    val examSchedule: List<ExamScheduleAddNew>,
    val exam_id: Int,
    val section_id: Int
)