package com.angdroid.minoslaboratory.di.main

import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import com.angdroid.minoslaboratory.data.repository.main.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class MainModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindsMainService(mainService: MainRepositoryImpl): MainRepository
}