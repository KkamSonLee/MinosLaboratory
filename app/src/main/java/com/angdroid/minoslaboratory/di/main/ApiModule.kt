package com.angdroid.minoslaboratory.di.main

import android.content.Context
import com.angdroid.minoslaboratory.data.api.LocalHostApi
import com.angdroid.minoslaboratory.data.api.MockApi
import com.angdroid.minoslaboratory.data.api.MockNetworkInterceptor
import com.angdroid.minoslaboratory.data.api.createMockApi
import com.angdroid.minoslaboratory.data.dto.mockAndroidVersions
import com.angdroid.minoslaboratory.data.dto.mockVersionFeaturesAndroid10
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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
    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun provideAuthRetrofit(json: Json): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://192.168.219.100:8080")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun providesLocalHostApi(retrofit: Retrofit) : LocalHostApi = retrofit.create(LocalHostApi::class.java)

}

