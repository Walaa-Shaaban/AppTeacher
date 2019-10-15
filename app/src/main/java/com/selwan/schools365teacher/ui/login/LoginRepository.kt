package com.selwan.schools365teacher.ui.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.google.android.material.snackbar.Snackbar
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.login.AccessLogin
import com.selwan.schools365teacher.data.model.login.LoginRoom
import com.selwan.schools365teacher.data.model.login.loginAccessPost
import com.selwan.schools365teacher.data.room.LoginDao
import com.selwan.schools365teacher.data.room.TeacherDatabase
import com.selwan.schools365teacher.data.utils.ApiUtils
import com.selwan.schools365teacher.ui.timetable.main.TimetableMainFragment.Companion.view
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login_fragment.*
import okhttp3.MediaType
import okhttp3.RequestBody
import com.google.gson.Gson
import kotlin.math.log


class LoginRepository(application: Application) {

    val msg = MutableLiveData<AccessLogin>()
    var loginDao: LoginDao
    companion object{
        var staffId: String ?= null
        var token :  String ?= null
    }



    init {
        var database = TeacherDatabase.invoke(
            application.applicationContext
        )
        loginDao = database.LoginDao()
    }
    fun login(
        compositeDisposable: CompositeDisposable, email: String, password: String): LiveData<AccessLogin> {
        compositeDisposable.add(
            ApiUtils.apiService.loginTeacher(getRequestBodyJson(loginAccessPost(email, password)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        val loginRoom = LoginRoom(id = it.record.id, email = it.record.email,image = it.record.image, staffId = it.staffId, token = it.token, username = it.record.username )
                        loginDao.insertUserLogin(loginRoom)
                        staffId = it.staffId
                        token = it.token



                    }, {
                        val snackbar =
                            Snackbar.make(
                                LoginFragment.getView,
                                it.message.toString(),
                                Snackbar.LENGTH_LONG
                            )
                        val sbView = snackbar.view
                        sbView.setBackgroundResource(R.color.green)
                        snackbar.show()
                    }
                ))
            return msg
        }


    private fun getRequestBodyJson(loginAccessPost: loginAccessPost): RequestBody {
        return RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            Gson().toJson(loginAccessPost)
        )
    }


}
