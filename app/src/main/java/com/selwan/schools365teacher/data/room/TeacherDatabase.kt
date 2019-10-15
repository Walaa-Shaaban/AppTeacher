package com.selwan.schools365teacher.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.selwan.schools365teacher.data.model.login.LoginRoom
import com.selwan.schools365teacher.data.model.notification.NotificationResponse

@Database(entities = [NotificationResponse::class, LoginRoom::class], version = 2, exportSchema = false)
abstract class TeacherDatabase : RoomDatabase() {

    abstract fun TeacherDao(): TeacherDao
    abstract fun LoginDao() : LoginDao

    companion object {
        @Volatile
        private var instance: TeacherDatabase? = null
        private val LOCK = Any()
        lateinit var context: Context
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            this.context = context
            instance ?: buildDatabase(context).also { instance = it }
        }

        //Access Database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            TeacherDatabase::class.java, "teachers.db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()


    }

}
