package com.app.gantabi.auth.data.network

import com.app.gantabi.auth.data.model.AccountDto
import com.app.gantabi.auth.data.model.SessionTokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountApiClient {

    @POST("/register")
    suspend fun registerUser(@Body examplePostDto: AccountDto): Response<SessionTokenDto>

    @POST("login")
    suspend fun loginUser(@Body userLogin: AccountDto): Response<SessionTokenDto>
}