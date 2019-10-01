package com.selwan.schools365teacher.data.model.event


import com.google.gson.annotations.SerializedName

data class SaveEvent(
    @SerializedName("msg")
    val msg: String
)