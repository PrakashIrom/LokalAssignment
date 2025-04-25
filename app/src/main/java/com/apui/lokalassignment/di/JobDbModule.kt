package com.apui.lokalassignment.di

import com.apui.lokalassignment.data.local.JobDatabase
import com.apui.lokalassignment.data.repository.JobDBRepositoryImpl
import com.apui.lokalassignment.domain.repository.JobDBRepository
import com.apui.lokalassignment.ui.bookmark.BookMarkViewModel
import org.koin.dsl.module

val jobDbModule = module {
    single {
        JobDatabase.getDatabase(get()).jobDao()
    }
    single<JobDBRepository> {
        JobDBRepositoryImpl(get())
    }
    single {
        BookMarkViewModel(get())
    }
}