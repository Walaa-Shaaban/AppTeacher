package com.selwan.schools365teacher.data.model.homework


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("class_id")
    val classId: String,
    @SerializedName("class")
    val classX: String,
    @SerializedName("create_date")
    val createDate: String,
    @SerializedName("created_by")
    val createdBy: String,
    @SerializedName("date")
    val date: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("document")
    val document: String,
    @SerializedName("evaluated_by")
    val evaluatedBy: String,
    @SerializedName("homework_date")
    val homeworkDate: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("section_id")
    val sectionId: String,
    @SerializedName("staff_id")
    val staffId: String,
    @SerializedName("subject_id")
    val subjectId: String,
    @SerializedName("submit_date")
    val submitDate: String
)