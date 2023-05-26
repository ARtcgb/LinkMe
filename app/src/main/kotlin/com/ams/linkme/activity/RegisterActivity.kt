package com.ams.linkme.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ams.linkme.R
import com.ams.linkme.databinding.ActivityRegisterBinding
import com.ams.linkme.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        val username = binding.editTextUsername
        val password = binding.editTextPassword
        val repeatPassword = binding.repeatTextPassword
        val button = binding.buttonRegister

        registerViewModel.usernameExists.observe(this) { exists ->
            if (exists) {
                Toast.makeText(this, getString(R.string.exist_username), Toast.LENGTH_SHORT).show()
            } else {
                val usernameText = username.text.toString()
                val passwordText = password.text.toString()
                registerViewModel.register(usernameText, passwordText)
            }
        }

        button.setOnClickListener {
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()
            val repeatPasswordText = repeatPassword.text.toString()

            if (usernameText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(this, getString(R.string.username_password_empty), Toast.LENGTH_SHORT).show()
            } else if (passwordText != repeatPasswordText) {
                Toast.makeText(this, getString(R.string.unmatched_password), Toast.LENGTH_SHORT).show()
            } else if (!registerViewModel.checkUsernameValidity(usernameText)) {
                Toast.makeText(this, getString(R.string.illegal_username), Toast.LENGTH_SHORT).show()
            } else {
                registerViewModel.checkUsernameExists(usernameText)
            }
        }
    }
}
