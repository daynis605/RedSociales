package com.app.gantabi.auth.domain.model

import com.app.gantabi.auth.data.model.AccountDto

data class Account(
    val email: String,
    val password: String
)

