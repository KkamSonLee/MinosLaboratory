package com.angdroid.minoslaboratory.domain.usecase

import com.angdroid.minoslaboratory.domain.entity.User
import com.angdroid.minoslaboratory.domain.repository.main.MainRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetUserInfo @Inject constructor(private val mainRepository: MainRepository) {
    suspend operator fun invoke(userName: String): User {
        val userId = mainRepository.getUserId(userName)
        val userCompany = mainRepository.getUserCompany(userId)
        return User(userName, userCompany, userId.toString())
    }
}