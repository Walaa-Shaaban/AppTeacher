package com.selwan.schools365teacher.data.utils

import com.selwan.schools365teacher.data.remote.ApiService
import com.selwan.schools365teacher.data.remote.RetrofitTeacher

object ApiUtils {

    val BASE_URL = "https://api.development.365edu.tech/"
    var token: String? = null
    val IMG_PATH = "http://development.365edu.tech/"
    var staff_id = null
    val apiService: ApiService = RetrofitTeacher.getClient()?.create(ApiService::class.java)!!


}