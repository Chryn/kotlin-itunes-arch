package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.di.diModules
import com.example.myapplication.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

open class TrackApp: Application() {

    override fun onCreate() {
        super.onCreate()

            // Start Koin
            startKoin {
                androidLogger()
                androidContext(this@TrackApp)
                modules(listOf(vmModule, diModules))
            }
    }
}