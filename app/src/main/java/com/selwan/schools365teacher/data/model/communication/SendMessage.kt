package com.selwan.schools365teacher.data.model.communication


import com.google.gson.annotations.SerializedName

data class SendMessage(
    @SerializedName("date")
    val date: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("publish_date")
    val publishDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("visible")
    val visible: List<Int>
)