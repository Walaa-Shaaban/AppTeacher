package com.selwan.schools365teacher.data.model.communication


import com.google.gson.annotations.SerializedName

data class NoticBoard(
    @SerializedName("notificationlist")
    val notificationlist: List<Notificationlist>,
    @SerializedName("user_id")
    val userId: String
)