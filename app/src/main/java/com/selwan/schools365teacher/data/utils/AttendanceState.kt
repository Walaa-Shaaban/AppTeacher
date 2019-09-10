package com.selwan.schools365teacher.data.utils

import android.graphics.Color

object AttendanceState {

    fun StateAttendance(state: String): List<Any> {

        var setAttendanceState: List<Any>? = null
        when (state) {
            "1" -> setAttendanceState = listOf(Color.parseColor("#0aad3f"), "Present")
            "2" -> setAttendanceState = listOf(Color.parseColor("#37D9F1"), "late")
            "3" -> setAttendanceState = listOf(Color.parseColor("#F137E2"), "Holiday")
            "4" -> setAttendanceState = listOf(Color.parseColor("#FB092D"), "Half Day")
            "5" -> setAttendanceState = listOf(Color.parseColor("#0aad3f"), "Absent")

        }
        return setAttendanceState!!
    }
}