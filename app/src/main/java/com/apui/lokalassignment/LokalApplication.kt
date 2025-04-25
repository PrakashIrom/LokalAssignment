package com.apui.lokalassignment

import android.app.Application
import com.apui.lokalassignment.di.bookMarkModule
import com.apui.lokalassignment.di.jobListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class LokalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LokalApplication)
            modules(jobListModule, bookMarkModule)
        }
    }
}