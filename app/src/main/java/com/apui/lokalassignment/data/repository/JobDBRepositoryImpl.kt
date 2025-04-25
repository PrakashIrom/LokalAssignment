package com.apui.lokalassignment.data.repository

import com.apui.lokalassignment.data.local.JobDAO
import com.apui.lokalassignment.data.model.JobEntity
import com.apui.lokalassignment.domain.repository.JobDBRepository
import kotlinx.coroutines.flow.Flow

class JobDBRepositoryImpl(private val jobDao: JobDAO) : JobDBRepository {
    override fun fetchJobs(): Flow<List<JobEntity>> = jobDao.getAllJobs()

    override suspend fun insertJob(job: JobEntity) {
        jobDao.insertJob(job)
    }

    override suspend fun deleteJob(job: JobEntity) {
        jobDao.deleteJob(job)
    }
}