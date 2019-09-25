package com.selwan.schools365teacher.data.model.attendance

data class StudentAttendance(
    val attendencetypeslist: List<Attendencetypeslist>,
    val otherNotes: List<OtherNote>,
    val resultlist: List<Resultlist>
)