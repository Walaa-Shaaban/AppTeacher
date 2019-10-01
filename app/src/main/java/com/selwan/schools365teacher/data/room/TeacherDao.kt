package com.selwan.schools365teacher.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.selwan.schools365teacher.data.model.notification.NotificationResponse


@Dao
interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotification(notificationResponse: NotificationResponse)

    @Query("SELECT * FROM NotificationResponse ORDER BY id DESC")
    fun getAllNotification(): LiveData<List<NotificationResponse>>

    @Delete
    fun deleteNotification(notificationResponse: NotificationResponse)


}