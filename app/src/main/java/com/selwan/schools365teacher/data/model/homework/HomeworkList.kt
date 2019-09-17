package com.selwan.schools365teacher.data.model.homework


import com.google.gson.annotations.SerializedName

data class HomeworkList(
    @SerializedName("items")
    val items: List<Item>
)