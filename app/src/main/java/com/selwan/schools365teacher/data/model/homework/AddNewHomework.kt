package com.selwan.schools365teacher.data.model.homework


import com.google.gson.annotations.SerializedName

data class AddNewHomework(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)