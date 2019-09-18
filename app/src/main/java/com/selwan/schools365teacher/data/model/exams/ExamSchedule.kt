package com.selwan.schools365teacher.data.model.exams

data class ExamSchedule(
    val class_id: String,
    val class_name: String,
    val created_at: String,
    val date_of_exam: String,
    val end_from: String,
    val exam_id: String,
    val full_marks: String,
    val id: String,
    val is_active: String,
    val name: String,
    val note: Any,
    val passing_marks: String,
    val room_no: String,
    val section_id: String,
    val section_name: String,
    val sesion_id: String,
    val session_id: String,
    val start_to: String,
    val subject_name: String,
    val teacher_subject_id: String,
    val updated_at: String
)