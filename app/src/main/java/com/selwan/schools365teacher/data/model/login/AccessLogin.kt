package com.selwan.schools365teacher.data.model.login

import com.google.gson.annotations.SerializedName


data class AccessLogin(
    @SerializedName("message")
    val message: String,
    @SerializedName("record")
    val record: Record,
    @SerializedName("staff_id")
    val staffId: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("token")
    val token: String
)