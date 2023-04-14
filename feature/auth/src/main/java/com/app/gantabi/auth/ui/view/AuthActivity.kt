package com.app.gantabi.auth.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.app.gantabi.auth.R
import com.app.gantabi.auth.databinding.ActivityAuthBinding
import com.app.gantabi.auth.domain.model.Account
import com.app.gantabi.auth.ui.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
  //  val view: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_auth_fragment) as NavHostFragment
      //  val account =Account("DAYNIS", "DSFDFSF")
      //  view.login(account)
    }
}