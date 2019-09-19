package com.selwan.schools365teacher.data.model.exams

data class Result(
    val admission_no: String,
    val dob: String,
    val exam_array: List<ExamArray>,
    val father_name: String,
    val firstname: String,
    val grand_total: String,
    val lastname: String,
    val percent: String,
    val result: String,
    val roll_no: String,
    val student_id: String
)