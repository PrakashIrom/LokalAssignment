package com.apui.lokalassignment.di

import com.apui.lokalassignment.data.remote.JobRemoteDataSource
import com.apui.lokalassignment.data.repository.JobRepositoryImpl
import com.apui.lokalassignment.domain.repository.JobRepository
import com.apui.lokalassignment.ui.home.JobListViewModel
import org.koin.dsl.module

val jobListModule = module {
    single { JobRemoteDataSource() }
    single<JobRepository> { JobRepositoryImpl(get()) }
    single { JobListViewModel(get()) }
}