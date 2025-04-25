package com.apui.lokalassignment.di

import com.apui.lokalassignment.data.local.BookMarkPreference
import com.apui.lokalassignment.data.repository.BookMarkPreferenceRepoImpl
import com.apui.lokalassignment.domain.repository.BookMarkPreferenceRepo
import com.apui.lokalassignment.ui.home.BookMarkPreferenceViewModel
import org.koin.dsl.module

val bookMarkModule = module {
    single { BookMarkPreference(get()) }
    single<BookMarkPreferenceRepo> { BookMarkPreferenceRepoImpl(get()) }
    single { BookMarkPreferenceViewModel(get()) }
}