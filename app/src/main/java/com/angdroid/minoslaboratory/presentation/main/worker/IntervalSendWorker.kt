package com.angdroid.minoslaboratory.presentation.main.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.angdroid.minoslaboratory.data.api.MockNetworkInterceptor
import com.angdroid.minoslaboratory.data.api.createMockApi
import com.angdroid.minoslaboratory.data.dto.mockAndroidVersions
import com.angdroid.minoslaboratory.data.dto.mockVersionFeaturesAndroid10
import com.google.gson.Gson
import java.time.LocalDateTime
import javax.inject.Singleton

@Singleton
class IntervalSendWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {

    val mockApi = createMockApi(
        MockNetworkInterceptor()
            .mock(
                "http://localhost/recent-android-versions",
                { Gson().toJson(mockAndroidVersions) },
                200,
                1500
            )
            .mock(
                "http://localhost/android-version-features/29",
                { Gson().toJson(mockVersionFeaturesAndroid10) },
                200,
                1500
            )
    )

    override suspend fun doWork(): Result {
        val versions = mockApi.getRecentAndroidVersions()
        Log.e("LMH", "get $versions ${LocalDateTime.now()}")
        return Result.success()
    }
}