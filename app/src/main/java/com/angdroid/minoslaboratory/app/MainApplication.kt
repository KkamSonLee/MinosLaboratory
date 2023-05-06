package com.angdroid.minoslaboratory.app

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import com.angdroid.minoslaboratory.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration = if (BuildConfig.DEBUG) {
        Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()
    } else {
        Configuration.Builder()
            .setMinimumLoggingLevel(Log.ERROR)
            .build()
    }

}