package com.app.gantabi.redsociales

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.gantabi.auth.ui.view.AuthActivity

class MainActivity : AppCompatActivity() {

    val CUSTOM_PREF_NAME = "USER_AUTH"
    val USER_ID = "USER_ID"
    val USER_PASSWORD = "PASSWORD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference: SharedPreferences =
            this.getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
        val userID = sharedPreference.getString(USER_ID, "NO_AUTH")

        if (userID.equals("NO_AUTH")) {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}