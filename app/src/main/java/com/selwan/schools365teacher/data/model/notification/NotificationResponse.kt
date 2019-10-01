package com.selwan.schools365teacher.data.model.notification

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "NotificationResponse")
class NotificationResponse {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    val title: String

    @ColumnInfo(name = "body")
    @SerializedName("body")
    @Expose
    val body: String


    constructor(title: String, body: String) {
        this.title = title
        this.body = body

    }
}