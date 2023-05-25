package com.ams.linkme.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val username = binding.editTextUsername
        val password = binding.editTextPassword
        val button = binding.buttonLogin

        button.setOnClickListener {
            loginViewModel.login(username.text.toString(), password.text.toString())
        }

        loginViewModel.loginSuccess.observe(this) { success ->
            if (success) {
                handleLoginSuccess()
            }
        }

        loginViewModel.loginFailure.observe(this) { error ->
            if (error != null) {
                handleLoginFailure(error)
            }
        }
    }

    private fun handleLoginSuccess() {
        // Update UI for successful login
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
        // Navigate to the next activity
    }

    private fun handleLoginFailure(error: String) {
        // Update UI for failed login
        Toast.makeText(this, "Login failed: $error", Toast.LENGTH_SHORT).show()
    }
}
