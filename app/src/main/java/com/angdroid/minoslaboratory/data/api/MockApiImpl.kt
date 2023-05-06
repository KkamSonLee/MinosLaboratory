package com.angdroid.minoslaboratory.data.api

import com.angdroid.minoslaboratory.data.dto.mockAndroidVersions
import com.angdroid.minoslaboratory.data.dto.mockVersionFeaturesAndroid10
import com.google.gson.Gson

fun mockApi() = createMockApi(
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