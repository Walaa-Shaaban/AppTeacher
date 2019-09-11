package com.selwan.schools365teacher.data.remote

import com.selwan.schools365teacher.data.model.attendance.AttendanceByDate
import com.selwan.schools365teacher.data.model.attendance.AttendanceReport
import com.selwan.schools365teacher.data.model.attendance.Attendencetypeslist
import com.selwan.schools365teacher.data.model.attendance.StudentAttendance
import com.selwan.schools365teacher.data.model.student_details.Classes
import com.selwan.schools365teacher.data.model.student_details.Sections
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.model.timetable.Timetable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getStudentsDetails")
    fun getAllStudentInSection(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<List<StudentDetails>>

    @GET("getClasses")
    fun getClasses(
    ): Single<List<Classes>>

    @GET("getSections")
    fun getSections(
        @Query("class_id") class_id: String
    ): Single<List<Sections>>

    @GET("studentAttendance")
    fun getAllStudentAttendance(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<StudentAttendance>

    @GET("studentAttendance")
    fun getAllAttendanceTypeList(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ) : Single<List<Attendencetypeslist>>

    @GET("attendanceByDate")
    fun getAllStudentAttendanceByDate(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String,
        @Query("date") date : String
    ): Single<AttendanceByDate>


    @GET("attendanceReport")
    fun getAllReportByMonth(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String,
        @Query("year") year : String,
        @Query("month") month : String
    ): Single<AttendanceReport>


    @GET("getClassTimeTable")
    fun getTimetable(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<Timetable>
}