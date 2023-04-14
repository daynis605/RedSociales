package com.app.gantabi.auth.data.model

import com.google.gson.annotations.SerializedName

data class SessionTokenDto(
    @SerializedName("token") val token: String,
    @SerializedName("id") val id: String?
)


