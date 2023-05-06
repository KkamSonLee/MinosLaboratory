package com.angdroid.minoslaboratory.di.main

import com.angdroid.minoslaboratory.data.api.MockApi
import com.angdroid.minoslaboratory.data.api.MockNetworkInterceptor
import com.angdroid.minoslaboratory.data.api.createMockApi
import com.angdroid.minoslaboratory.data.dto.mockAndroidVersions
import com.angdroid.minoslaboratory.data.dto.mockVersionFeaturesAndroid10
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    fun mockApi(): MockApi = createMockApi(
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

}