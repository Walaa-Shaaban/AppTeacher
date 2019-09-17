package com.selwan.schools365teacher.data.remote

import com.selwan.schools365teacher.data.model.attendance.*
import com.selwan.schools365teacher.data.model.communication.NoticBoard
import com.selwan.schools365teacher.data.model.homework.AddNewHomework
import com.selwan.schools365teacher.data.model.homework.HomeworkList
import com.selwan.schools365teacher.data.model.homework.Subject
import com.selwan.schools365teacher.data.model.news.News
import com.selwan.schools365teacher.data.model.student_details.Classes
import com.selwan.schools365teacher.data.model.student_details.Sections
import com.selwan.schools365teacher.data.model.student_details.StudentDetails
import com.selwan.schools365teacher.data.model.timetable.Timetable
import io.reactivex.Single
import retrofit2.http.*

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


    @GET("getHomeWork")
    fun getHomeworkList(
    ): Single<HomeworkList>

    @FormUrlEncoded
    @POST("addHomeWork")
    fun add_homework(
        @Field("class_id") class_id: String,
        @Field("section_id") section_id: String,
        @Field("subject_id") subject_id: String,
        @Field("homework_date") homework_date: String,
        @Field("submit_date") submit_date: String,
        @Field("description") description: String
    ): Single<AddNewHomework>

    @GET("getNoticeBoard")
    fun getNoticBoard(): Single<NoticBoard>

    @GET("getSubjectsTeacher")
    fun getSubject(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<List<Subject>>

    @FormUrlEncoded
    @POST("saveStudentAttendance")
    fun attendanceSave(
        @Field("class_id") class_id: String,
        @Field("section_id") section_id: String,
        @Field("date") date: String,
        @Field("holiday") holiday: Boolean,
        @Field("student_session") studentSession: List<StudentSession>
    ): Single<AttendanceMsg>

    @GET("getNews")
    fun getNews()
            : Single<News>
}