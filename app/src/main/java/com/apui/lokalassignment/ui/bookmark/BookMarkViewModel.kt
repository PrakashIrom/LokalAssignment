package com.apui.lokalassignment.ui.bookmark

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apui.lokalassignment.data.model.JobEntity
import com.apui.lokalassignment.domain.repository.JobDBRepository
import kotlinx.coroutines.launch

class BookMarkViewModel(private val jobDBRepository: JobDBRepository) : ViewModel() {
    private val _jobList = mutableStateListOf<JobEntity>()
    val jobList: List<JobEntity>
        get() = _jobList

    var selectedJob: JobEntity? by mutableStateOf(null)
        private set

    init {
        viewModelScope.launch {
            jobDBRepository.fetchJobs().collect {
                _jobList.clear()
                _jobList.addAll(it)
            }
        }
    }

    fun insertJob(job: JobEntity) {
        viewModelScope.launch {
            jobDBRepository.insertJob(job)
        }
    }

    fun deleteJob(job: JobEntity) {
        viewModelScope.launch {
            jobDBRepository.deleteJob(job)
        }
    }

    fun selectJob(job: JobEntity) {
        selectedJob = job
    }
}