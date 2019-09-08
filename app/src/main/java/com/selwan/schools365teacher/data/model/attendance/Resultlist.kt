package com.selwan.schools365teacher.data.model.attendance


import com.google.gson.annotations.SerializedName

data class Resultlist(
    @SerializedName("admission_no")
    val admissionNo: String,
    @SerializedName("att_type")
    val attType: Any,
    @SerializedName("attendence_id")
    val attendenceId: String,
    @SerializedName("attendence_type_id")
    val attendenceTypeId: Any,
    @SerializedName("date")
    val date: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("key")
    val key: Any,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("remark")
    val remark: Any,
    @SerializedName("roll_no")
    val rollNo: String,
    @SerializedName("student_session_id")
    val studentSessionId: String
)