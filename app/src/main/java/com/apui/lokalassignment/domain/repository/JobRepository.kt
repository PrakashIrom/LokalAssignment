package com.apui.lokalassignment.domain.repository

import com.apui.lokalassignment.data.model.JobListResponse

interface JobRepository {
        suspend fun fetchJobs(page: Int): JobListResponse
}