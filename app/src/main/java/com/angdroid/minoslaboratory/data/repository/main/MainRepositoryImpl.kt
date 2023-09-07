package com.angdroid.minoslaboratory.data.repository.main

import com.angdroid.minoslaboratory.data.api.LocalHostApi
import com.angdroid.minoslaboratory.data.dto.MyData
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random
import kotlin.random.nextUInt

@Singleton
class MainRepositoryImpl @Inject constructor(private val localHostApi: LocalHostApi) : MainRepository {
    private val coroutineContext = Dispatchers.Main
    override suspend fun getUserId(userName: String): UInt = withContext(coroutineContext) {
        Random.nextUInt()
    }

    override suspend fun getUserCompany(userId: UInt): String = withContext(coroutineContext) {
        "마드라스체크"
    }

    override suspend fun getHelloWorld(): String = localHostApi.getHelloWorld()

    override suspend fun getMessage(): MyData = localHostApi.getMessage()

    override suspend fun postMessage(message: MyData): MyData = localHostApi.postMessage(message)
}