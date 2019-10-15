package com.selwan.schools365teacher.data.model.login


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "login")
data class LoginRoom(


    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,

    @ColumnInfo(name = "email")
    @SerializedName("email")
    @Expose
    val email: String,


    @ColumnInfo(name = "image")
    @Expose
    @SerializedName("image")
    val image: String,

    @ColumnInfo(name = "staff_id")
    @Expose
    @SerializedName("staff_id")
    val staffId: String,

    @ColumnInfo(name = "token")
    @Expose
    @SerializedName("token")
    val token: String,

    @ColumnInfo(name = "username")
    @Expose
    @SerializedName("username")
    val username: String
)