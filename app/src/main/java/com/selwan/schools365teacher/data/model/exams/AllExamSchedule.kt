package com.selwan.schools365teacher.data.model.exams

data class AllExamSchedule(
    val error: String,
    val examSchedule: List<ExamSchedule>,
    val exams: List<Exam>,
    val status: Int
)