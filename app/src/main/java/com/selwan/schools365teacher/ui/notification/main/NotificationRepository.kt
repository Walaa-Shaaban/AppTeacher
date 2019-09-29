package com.selwan.schools365teacher.ui.notification.main

import android.app.Application
import com.selwan.schools365teacher.data.room.TeacherDao
import com.selwan.schools365teacher.data.room.TeacherDatabase
import com.selwan.schools365teacher.ui.notification.service.NotificationService

class NotificationRepository(application: Application) {

    var databaseDao: TeacherDao

    init {
        var database = TeacherDatabase.invoke(
            application.applicationContext
        )
        databaseDao = database.TeacherDao()
        if (NotificationService.is_added) {
            addNotification()
            NotificationService.is_added = false
        }

    }


    fun addNotification() {

        NotificationService.notificatioResponse?.let {
            databaseDao.insertNotification(it)
        }


    }

    val getAllNotification by lazy { databaseDao.getAllNotification() }

}

