package com.angdroid.minoslaboratory.domain.repository.main

import com.angdroid.minoslaboratory.data.dto.AndroidVersion
import com.angdroid.minoslaboratory.domain.entity.User

interface MainRepository {
    suspend fun getUserId(userName: String): UInt
    suspend fun getUserCompany(userId: UInt): String
    suspend fun getUserInfo(userName: String): User
}