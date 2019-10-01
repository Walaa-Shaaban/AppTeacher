package com.selwan.schools365teacher.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.selwan.schools365teacher.data.model.notification.NotificationResponse

@Database(entities = [NotificationResponse::class], version = 1, exportSchema = false)
abstract class TeacherDatabase : RoomDatabase() {

    abstract fun TeacherDao(): TeacherDao

    companion object {
        @Volatile
        private var instance: TeacherDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
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
