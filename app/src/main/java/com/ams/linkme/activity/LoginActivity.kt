package com.ams.linkme.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ams.linkme.R
import com.ams.linkme.databinding.ActivityLoginBinding
import com.ams.linkme.viewModel.LoginViewModel

/**
 * LoginActivity is responsible for handling user logins.
 *
 * The activity displays login interface with fields for username and password, and a login button.
 * When the login button is clicked, it will pass the input to LoginViewModel to handle the business logic.
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding   = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.editTextUsername
        val password = binding.editTextPassword
        val button = binding.buttonLogin

        button.setOnClickListener {
            loginViewModel.logIn(username.text.toString(), password.text.toString())
        }
    }

}