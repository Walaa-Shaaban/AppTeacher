package com.selwan.schools365teacher.data.model.event


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("end_date")
    val endDate: String,
    @SerializedName("event_color")
    val eventColor: String,
    @SerializedName("event_description")
    val eventDescription: String,
    @SerializedName("event_for")
    val eventFor: String,
    @SerializedName("event_title")
    val eventTitle: String,
    @SerializedName("event_type")
    val eventType: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("role_id")
    val roleId: String,
    @SerializedName("start_date")
    val startDate: String
)