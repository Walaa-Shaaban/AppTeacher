package com.selwan.schools365teacher.data.model.event


import com.google.gson.annotations.SerializedName

data class AllEvent(
    @SerializedName("events")
    val events: List<Event>
)