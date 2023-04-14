package com.app.gantabi.auth.data

import com.app.gantabi.auth.data.model.AccountDto
import com.app.gantabi.auth.data.model.SessionTokenDto
import com.app.gantabi.auth.data.network.AccountService
import com.app.gantabi.auth.domain.model.Session
import com.app.gantabi.auth.domain.toDomain
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val apiService: AccountService
) {
    suspend fun loginUserFromApi(accountDto: AccountDto): Session?{
        val response: SessionTokenDto? = apiService.loginUser(accountDto)
        return response?.toDomain()
    }

    suspend fun registerUserFromApi(accountDto: AccountDto): Session?{
        val response: SessionTokenDto? = apiService.registerUser(accountDto)
        return response?.toDomain()
    }




}