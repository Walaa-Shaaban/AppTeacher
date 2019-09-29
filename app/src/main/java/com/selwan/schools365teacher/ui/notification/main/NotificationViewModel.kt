package com.selwan.schools365teacher.ui.notification.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class NotificationViewModel(application: Application) : AndroidViewModel(application) {

    var notificationRepository: NotificationRepository

    init {
        notificationRepository = NotificationRepository(application)

    }

    val getAllNotification by lazy { notificationRepository.getAllNotification }

}
