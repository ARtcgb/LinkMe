package com.ams.linkme.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ams.linkme.model.Message
import com.ams.linkme.networking.ApiService
import kotlinx.coroutines.launch
import retrofit2.Response

class ChatViewModel(private val apiService: ApiService) : ViewModel() {

    // LiveData for messages
    val messagesLiveData: MutableLiveData<List<Message>> = MutableLiveData()

    // Fetch messages from server
    fun fetchMessages(userId: String, friendId: String) {
        viewModelScope.launch {
            val response: Response<List<Message>> = apiService.getMessages(userId, friendId)
            if (response.isSuccessful) {
                messagesLiveData.value = response.body()
            } else {
                // Handle error
            }
        }
    }

    // Send a message to server
    fun sendMessage(message: Message) {
        viewModelScope.launch {
            val response: Response<Message> = apiService.sendMessage(message)
            if (response.isSuccessful) {
                // The message was sent successfully
            } else {
                // Handle error
            }
        }
    }
}
