package com.angdroid.minoslaboratory.data.repository.main

import com.angdroid.minoslaboratory.data.dto.AndroidVersion
import com.angdroid.minoslaboratory.data.api.MockApi
import com.angdroid.minoslaboratory.domain.entity.User
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random
import kotlin.random.nextUInt

@Singleton
class MainRepositoryImpl @Inject constructor() : MainRepository {
    private val coroutineContext = Dispatchers.Main
    override suspend fun getUserId(userName: String): UInt = withContext(coroutineContext) {
        Random.nextUInt()
    }

    override suspend fun getUserCompany(userId: UInt): String = withContext(coroutineContext) {
        "마드라스체크"
    }

    override suspend fun getUserInfo(userName: String): User = withContext(coroutineContext) {
        val userId = getUserId(userName)
        val userCompany = getUserCompany(userId)
        User(userName, userCompany, userId.toString())
    }

}