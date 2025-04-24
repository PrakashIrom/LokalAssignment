package com.apui.lokalassignment.data.repository

import com.apui.lokalassignment.data.model.JobListResponse
import com.apui.lokalassignment.data.remote.JobRemoteDataSource
import com.apui.lokalassignment.domain.repository.JobRepository

class JobRepositoryImpl(private val remoteDataSource: JobRemoteDataSource) : JobRepository {
    override suspend fun fetchJobs(page: Int): JobListResponse {
        return remoteDataSource.fetchJobs(page)
    }
}