package com.ams.linkme.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ams.linkme.model.LoginRequest
import com.ams.linkme.networking.ApiService
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val apiService = ApiService.create()
    val loginSuccess = MutableLiveData<Boolean>()
    val loginFailure = MutableLiveData<String>()
    fun login(username: String, password: String) {
        viewModelScope.launch {
            val loginRequest = LoginRequest(username, password)
            val response = apiService.login(loginRequest)

            if (response.isSuccessful) {
                // Handle successful login
                loginSuccess.value = true
            } else {
                // Handle unsuccessful login
                loginFailure.value = "Login failed: ${response.errorBody()?.string()}"
            }
        }
    }
}


