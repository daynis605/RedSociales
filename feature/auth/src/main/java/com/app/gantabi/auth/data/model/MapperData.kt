package com.app.gantabi.auth.data.model

import com.app.gantabi.auth.domain.model.Account
import com.app.gantabi.auth.domain.model.Session

fun Session.toDto() = token?.let { SessionTokenDto(it, id) }

fun Account.toDto() = AccountDto(email, password)