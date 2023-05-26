package com.ams.linkme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ams.linkme.model.RegisterRequest
import com.ams.linkme.networking.ApiService
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class RegisterViewModel : ViewModel() {
    private val apiService = ApiService.create()
    private val _usernameExists = MutableLiveData<Boolean>()
    val usernameExists: LiveData<Boolean> get() = _usernameExists

    fun register(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = apiService.register(RegisterRequest(username, password))
                if (response.isSuccessful) {
                    // Handle successful registration
                } else {
                    // Handle registration error
                }
            } catch (e: Exception) {
                // Handle network error
            }
        }
    }

    fun checkUsernameExists(username: String) {
        viewModelScope.launch {
            try {
                val response = apiService.checkUsernameExists(username)
                _usernameExists.value = response.isSuccessful && response.body() == true
            } catch (e: Exception) {
                // Handle network error
            }
        }
    }

    fun checkUsernameValidity(username: String): Boolean {
        if (username.length < 6 || username.length > 20) {
            return false
        }

        if (username[0].isDigit()) {
            return false
        }

        for (char in username) {
            if (!char.isLetterOrDigit() && char != '-') {
                return false
            }
        }

        return true
    }
}
