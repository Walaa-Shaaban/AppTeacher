package com.selwan.schools365teacher.data.remote

import android.icu.text.CaseMap
import com.selwan.schools365teacher.data.model.attendance.*
import com.selwan.schools365teacher.data.model.communication.NoticBoard
import com.selwan.schools365teacher.data.model.event.AllEvent
import com.selwan.schools365teacher.data.model.event.SaveEvent
import com.selwan.schools365teacher.data.model.exams.AllExamSchedule
import com.selwan.schools365teacher.data.model.exams.ExamScheduleAddNew
import com.selwan.schools365teacher.data.model.exams.ResultAddNewExam
import com.selwan.schools365teacher.data.model.exams.ViewMark
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

    @GET("WebserviceTeacher/getStudentsDetails")
    fun getAllStudentInSection(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<List<StudentDetails>>

    @GET("WebserviceTeacher/getClasses")
    fun getClasses(
    ): Single<List<Classes>>

    @GET("WebserviceTeacher/getSections")
    fun getSections(
        @Query("class_id") class_id: String
    ): Single<List<Sections>>

    @GET("WebserviceTeacher/studentAttendance")
    fun getAllStudentAttendance(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<StudentAttendance>

    @GET("WebserviceTeacher/studentAttendance")
    fun getAllAttendanceTypeList(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ) : Single<List<Attendencetypeslist>>

    @GET("WebserviceTeacher/attendanceByDate")
    fun getAllStudentAttendanceByDate(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String,
        @Query("date") date : String
    ): Single<AttendanceByDate>


    @GET("WebserviceTeacher/attendanceReport")
    fun getAllReportByMonth(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String,
        @Query("year") year : String,
        @Query("month") month : String
    ): Single<AttendanceReport>


    @GET("WebserviceTeacher/getClassTimeTable")
    fun getTimetable(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<Timetable>


    @GET("WebserviceTeacher/getHomeWork")
    fun getHomeworkList(
    ): Single<HomeworkList>

    @FormUrlEncoded
    @POST("WebserviceTeacher/addHomeWork")
    fun add_homework(
        @Field("class_id") class_id: String,
        @Field("section_id") section_id: String,
        @Field("subject_id") subject_id: String,
        @Field("homework_date") homework_date: String,
        @Field("submit_date") submit_date: String,
        @Field("description") description: String
    ): Single<AddNewHomework>

    @GET("WebserviceTeacher/getNoticeBoard")
    fun getNoticBoard(): Single<NoticBoard>

    @GET("WebserviceTeacher/getSubjectsTeacher")
    fun getSubject(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<List<Subject>>

    @FormUrlEncoded
    @POST("WebserviceTeacher/saveStudentAttendance")
    fun attendanceSave(
        @Field("class_id") class_id: String,
        @Field("section_id") section_id: String,
        @Field("date") date: String,
        @Field("holiday") holiday: Boolean,
        @Field("student_session") studentSession: List<StudentSession>
    ): Single<AttendanceMsg>

    @GET("Webservice/getNews")
    fun getNews()
            : Single<News>

    @GET("WebserviceTeacher/getEvents")
    fun getEvents(): Single<AllEvent>

    @GET("WebserviceTeacher/getExamSchedule")
    fun getAllExams(
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<AllExamSchedule>

    @FormUrlEncoded
    @POST("WebserviceTeacher/assignExamSchedule")
    fun addNewExam(
        @Field("exam_id") exam_id: String,
        @Field("class_id") class_id: String,
        @Field("section_id") section_id: String,
        @Field("examSchedule") examSchedule: List<ExamScheduleAddNew>
    ): Single<ResultAddNewExam>

    @GET("WebserviceTeacher/getMarksRegister")
    fun getViewMark(
        @Query("exam_id") exam_id: String,
        @Query("class_id") class_id: String,
        @Query("section_id") section_id: String
    ): Single<ViewMark>

    @FormUrlEncoded
    @POST("WebserviceTeacher/saveEvent")
    fun addNewEvent(
        @Field("title") title: String,
        @Field("description") description: String,
        @Field("event_type") event_type: String,
        @Field("start_date") start_date: String,
        @Field("end_date") endTime: String
    ): Single<SaveEvent>

}