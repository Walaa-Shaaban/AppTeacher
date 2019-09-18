package com.selwan.schools365teacher.data.model.exams

data class Exam(
    val created_at: String,
    val id: String,
    val is_active: String,
    val name: String,
    val note: String,
    val sesion_id: String,
    val updated_at: String
)