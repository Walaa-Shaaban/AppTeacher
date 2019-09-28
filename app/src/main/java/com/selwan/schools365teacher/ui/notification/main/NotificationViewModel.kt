package com.selwan.schools365teacher.ui.notification.main

import androidx.lifecycle.ViewModel

class NotificationViewModel : ViewModel() {

    var notificationRepository: NotificationRepository

    init {
        notificationRepository = NotificationRepository()

    }

    val getNotificationInfo by lazy {
        notificationRepository.notification_data
    }
}
