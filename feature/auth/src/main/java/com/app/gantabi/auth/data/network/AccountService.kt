package com.app.gantabi.auth.data.network

import com.app.gantabi.auth.data.model.AccountDto
import com.app.gantabi.auth.data.model.SessionTokenDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountService @Inject constructor(private val api: AccountApiClient) {

    suspend fun loginUser(userLogin: AccountDto): SessionTokenDto? {
        return withContext(Dispatchers.IO) {
            val response = api.loginUser(userLogin)
            response.body() ?: null
        }
    }

    suspend fun registerUser(userLogin: AccountDto): SessionTokenDto? {
        return withContext(Dispatchers.IO) {
            val response = api.registerUser(userLogin)
            response.body() ?: null
        }
    }

}
