package com.angdroid.minoslaboratory.domain.repository.main

import com.angdroid.minoslaboratory.data.dto.MyData

interface MainRepository {
    suspend fun getUserId(userName: String): UInt
    suspend fun getUserCompany(userId: UInt): String
    suspend fun getHelloWorld(): String
    suspend fun getMessage(): MyData
    suspend fun postMessage(message: MyData): MyData
}