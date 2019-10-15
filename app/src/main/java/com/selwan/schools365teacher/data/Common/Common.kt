package com.selwan.schools365teacher.data.Common

import android.content.Context
import com.selwan.schools365teacher.data.room.LoginDao
import com.selwan.schools365teacher.data.room.TeacherDatabase

object Common {
    lateinit var context: Context
    lateinit var loginDao: LoginDao
    var email: String = ""
    var username: String = ""
    var image: String = ""
    var staffId: String = ""
    var token: String = ""


    fun getLogin() {
        var database = TeacherDatabase.invoke(
            context
        )

        email = loginDao.getLoginAccess().email
        username = loginDao.getLoginAccess().username
        image = loginDao.getLoginAccess().image
        staffId = loginDao.getLoginAccess().staffId
        token = loginDao.getLoginAccess().token
    }


}