package com.apui.lokalassignment.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apui.lokalassignment.data.model.JobListResponse
import com.apui.lokalassignment.data.model.JobResponse
import com.apui.lokalassignment.domain.repository.JobRepository
import kotlinx.coroutines.launch

sealed interface JobStates {
    data class Success(val data: JobListResponse) : JobStates
    data class Error(val message: String) : JobStates
    data object Loading : JobStates
}

class JobListViewModel(private val jobRepository: JobRepository) : ViewModel() {

    private var _jobState by mutableStateOf<JobStates>(JobStates.Loading)
    val jobState: JobStates
        get() = _jobState

    var selectedJob: JobResponse? by mutableStateOf(null)
        private set

    private var currentPage = 1

    init {
        loadMorePage()
    }

    private fun loadMorePage() {
        viewModelScope.launch {
            _jobState = JobStates.Loading
            _jobState = try {
                JobStates.Success(jobRepository.fetchJobs(currentPage))
            } catch (e: Exception) {
                JobStates.Error(e.message.toString())
            }
        }
    }

    fun selectJob(job: JobResponse) {
        selectedJob = job
    }

}