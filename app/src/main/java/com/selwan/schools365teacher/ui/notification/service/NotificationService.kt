package com.selwan.schools365teacher.ui.notification.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.selwan.schools365teacher.R
import com.selwan.schools365teacher.data.model.notification.NotificationResponse
import com.selwan.schools365teacher.ui.notification.main.NotificationActivity

class NotificationService : FirebaseMessagingService() {


    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        //Here notification is recieved from server
        try {
            sendNotification(
                remoteMessage.data.get("title").toString(),
                remoteMessage.data.get("body").toString()
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun sendNotification(title: String, messageBody: String) {

        val intent = Intent(applicationContext, NotificationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val mNotifyManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_LOW
            val mChannel = NotificationChannel("teacher_app", "teacher_app", importance)
            mChannel.description = messageBody
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)
            mChannel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            mNotifyManager.createNotificationChannel(mChannel)
        }
        //For Android Version lower than oreo.
        val mBuilder = NotificationCompat.Builder(this, "teacher_app")
        mBuilder.setContentTitle(title)
            .setVibrate(longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400))
            .setContentText(messageBody)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setColor(Color.parseColor("#FFD600"))
            .setContentIntent(pendingIntent)
            .setChannelId("teacher_app").priority = NotificationCompat.PRIORITY_HIGH

        mNotifyManager.notify(count, mBuilder.build())
        count++
        notificatioResponse = NotificationResponse(title = title, body = messageBody)
        is_added = true

    }

    companion object {

        private val TAG = "FCM Service"
        private var count = 0
        var notificatioResponse: NotificationResponse? = null
        var is_added = false
    }

}