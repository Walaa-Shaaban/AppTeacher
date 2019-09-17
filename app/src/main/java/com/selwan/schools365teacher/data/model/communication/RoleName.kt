package com.selwan.schools365teacher.data.model.communication


import com.google.gson.annotations.SerializedName

data class RoleName(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("is_superadmin")
    val isSuperadmin: String,
    @SerializedName("is_system")
    val isSystem: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: Any,
    @SerializedName("updated_at")
    val updatedAt: String
)