package com.kodelabs.boilerplate

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class AndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // initiate Timber
        Timber.plant(DebugTree())
    }
}
