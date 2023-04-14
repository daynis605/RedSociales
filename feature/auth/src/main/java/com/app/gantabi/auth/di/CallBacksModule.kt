package com.app.gantabi.auth.di

import com.app.gantabi.auth.ui.view.AuthFragment
import com.app.gantabi.auth.ui.view.LoginResultCallBacks
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class CallBacksModule {

    @Provides
    fun binLoginResultCallBacks(example:AuthFragment): LoginResultCallBacks = example
}