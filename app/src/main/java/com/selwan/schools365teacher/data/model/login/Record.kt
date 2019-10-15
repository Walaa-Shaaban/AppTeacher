package com.selwan.schools365teacher.data.model.login


import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("username")
    val username: String
)