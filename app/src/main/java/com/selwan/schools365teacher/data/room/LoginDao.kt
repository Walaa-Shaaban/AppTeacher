package com.selwan.schools365teacher.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.selwan.schools365teacher.data.model.login.LoginRoom

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserLogin(loginRoom: LoginRoom)

    @Query("SELECT * FROM login")
    fun getLoginAccess(): LoginRoom
}