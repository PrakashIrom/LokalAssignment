package com.apui.lokalassignment.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apui.lokalassignment.data.model.JobEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JobDAO {
    @Query("SELECT * FROM jobs")
    fun getAllJobs(): Flow<List<JobEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJob(job: JobEntity)

    @Delete
    suspend fun deleteJob(task: JobEntity)

}