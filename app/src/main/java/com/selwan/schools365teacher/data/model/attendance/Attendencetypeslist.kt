package com.selwan.schools365teacher.data.model.attendance


import com.google.gson.annotations.SerializedName

data class Attendencetypeslist(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("key_value")
    val keyValue: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String
)