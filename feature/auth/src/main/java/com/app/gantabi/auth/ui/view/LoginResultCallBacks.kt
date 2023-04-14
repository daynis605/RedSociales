package com.app.gantabi.auth.ui.view

import android.view.View

interface LoginResultCallBacks {

    fun onSuccess(message:String)
    fun onError(message: String)
}