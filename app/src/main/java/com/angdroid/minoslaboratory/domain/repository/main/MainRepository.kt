package com.angdroid.minoslaboratory.domain.repository.main

interface MainRepository {
    suspend fun getUserId(userName: String): UInt
    suspend fun getUserCompany(userId: UInt): String
}