package com.app.gantabi.auth.data.model

import com.google.gson.annotations.SerializedName

data class AccountDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
