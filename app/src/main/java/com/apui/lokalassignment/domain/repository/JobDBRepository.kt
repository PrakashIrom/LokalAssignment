package com.apui.lokalassignment.domain.repository

import com.apui.lokalassignment.data.model.JobEntity
import kotlinx.coroutines.flow.Flow

interface JobDBRepository {
     fun fetchJobs(): Flow<List<JobEntity>>
    suspend fun insertJob(job: JobEntity)
    suspend fun deleteJob(job: JobEntity)
}