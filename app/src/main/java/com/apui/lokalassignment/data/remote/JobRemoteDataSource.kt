package com.apui.lokalassignment.data.remote

import com.apui.lokalassignment.data.model.JobListResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.http.headers

const val BASE_URL = "https://testapi.getlokalapp.com/common/jobs"

class JobRemoteDataSource {
    suspend fun fetchJobs(page: Int): JobListResponse {
        return JobClient.client.get(BASE_URL) {
            parameter("page", page)
            headers {
               // append(HttpHeaders.Accept,"*/*")
            }
        }.body()
    }
}