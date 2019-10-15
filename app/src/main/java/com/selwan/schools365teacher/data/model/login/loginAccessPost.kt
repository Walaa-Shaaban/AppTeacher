package com.selwan.schools365teacher.data.model.login


import com.google.gson.annotations.SerializedName

data class loginAccessPost(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)