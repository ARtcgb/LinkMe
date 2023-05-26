package com.ams.linkme.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val username = binding.editTextUsername
        val password = binding.editTextPassword
        val button = binding.buttonLogin

        val registerTextView: TextView = findViewById(R.id.text_view_register)

        registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()

            if (usernameText.isEmpty() || passwordText.isEmpty()) {
                // Display a message to the user
                Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel.login(usernameText, passwordText)
            }
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
        // Create an Intent to start MainActivity
        val intent = Intent(this, MainActivity::class.java)
        // Start MainActivity
        startActivity(intent)
        // Optionally, if you don't want the user to be able to go back to LoginActivity
        // by pressing the back button, you can finish LoginActivity
        finish()
    }

    private fun handleLoginFailure(error: String) {
        // Update UI for failed login
        Toast.makeText(this, "Login failed: $error", Toast.LENGTH_SHORT).show()
    }
}

