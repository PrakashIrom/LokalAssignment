package com.apui.lokalassignment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.apui.lokalassignment.data.model.JobEntity

@Database(entities = [JobEntity::class], version = 3, exportSchema = false)
abstract class JobDatabase : RoomDatabase() {

    abstract fun jobDao(): JobDAO

    companion object {
        @Volatile
        private var Instance: JobDatabase? = null

        fun getDatabase(context: Context): JobDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, JobDatabase::class.java, "job_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}