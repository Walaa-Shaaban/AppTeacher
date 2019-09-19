package com.selwan.schools365teacher.data.model.exams

data class ExamScheduleAddNew(
    val date_of_exam: String,
    val end_from: String,
    val full_marks: String,
    val passing_marks: String,
    val room_no: String,
    val start_to: String,
    val teacher_subject_id: Int
)