package com.selwan.schools365teacher.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.selwan.schools365teacher.data.Common.Common
import com.selwan.schools365teacher.data.room.LoginDao
import com.selwan.schools365teacher.data.room.TeacherDatabase
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.login.LoginRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitTeacher {

    var retrofit: Retrofit? = null
    val REQUEST_TIMEOUT = 60
    var okHttpClient: OkHttpClient? = null


    fun getClient(): Retrofit? {


        if (okHttpClient == null)
            initOkHttp()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .client(okHttpClient!!)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        }
        return retrofit
    }


    private fun initOkHttp() {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        httpClient.addInterceptor(interceptor)

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()

            requestBuilder

                .addHeader("Request-Type", "Android")
                .addHeader("Content-Type", "application/json")
                .addHeader("Auth-Key", "365eduAdmin@")
                .addHeader("Client-Service", "365edu")

            if (!Common.staffId.isEmpty()) {
                Common.getLogin()
                requestBuilder
                    .addHeader("Authorization", Common.staffId)
                    .addHeader("Staff-ID", Common.token)

            }

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        okHttpClient = httpClient.build()
    }

    fun resetApiClient() {
        retrofit = null
        okHttpClient = null
    }

}

