package com.selwan.schools365teacher.data.model.communication


import com.google.gson.annotations.SerializedName

data class Notificationlist(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_by")
    val createdBy: String,
    @SerializedName("created_id")
    val createdId: String,
    @SerializedName("createdby_name")
    val createdbyName: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("publish_date")
    val publishDate: String,
    @SerializedName("role_name")
    val roleName: List<RoleName>,
    @SerializedName("roles")
    val roles: String,
    @SerializedName("send_notification_id")
    val sendNotificationId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("visible_parent")
    val visibleParent: String,
    @SerializedName("visible_staff")
    val visibleStaff: String,
    @SerializedName("visible_student")
    val visibleStudent: String
)