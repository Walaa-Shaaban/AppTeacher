package com.selwan.schools365teacher.data.model.attendance


import com.google.gson.annotations.SerializedName

data class StudentAttendance(
    @SerializedName("attendencetypeslist")
    val attendencetypeslist: List<Attendencetypeslist>,
    @SerializedName("resultlist")
    val resultlist: List<Resultlist>
)