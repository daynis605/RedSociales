package com.app.gantabi.auth.domain.model

import com.google.gson.annotations.SerializedName

data class Session(
    val token: String? = "default",
    val id: String? = "default",
    var code: Int? = 900
)
