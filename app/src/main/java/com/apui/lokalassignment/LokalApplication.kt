package com.apui.lokalassignment

import android.app.Application
import com.apui.lokalassignment.di.jobListModule
import org.koin.core.context.GlobalContext.startKoin

class LokalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(jobListModule)
        }
    }
}