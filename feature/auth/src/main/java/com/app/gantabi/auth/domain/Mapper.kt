package com.app.gantabi.auth.domain

import com.app.gantabi.auth.data.model.AccountDto
import com.app.gantabi.auth.data.model.SessionTokenDto
import com.app.gantabi.auth.domain.model.Account
import com.app.gantabi.auth.domain.model.Session

fun AccountDto.toDomain() = Account(email, password)
fun SessionTokenDto.toDomain() = Session(token, id)
