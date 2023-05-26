package com.ams.linkme.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ams.linkme.databinding.ActivityRegisterBinding
import com.ams.linkme.viewModel.RegisterViewModel

class RegisterActivity: AppCompatActivity() {

    private lateinit var loginViewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}