package com.ams.linkme.networking

import com.ams.linkme.model.Message
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("chat/{userId}/{friendId}")
    suspend fun getMessages(
        @Path("userId") userId: String,
        @Path("friendId") friendId: String
    ): Response<List<Message>>

    @POST("chat/sendMessage")
    suspend fun sendMessage(
        @Body message: Message
    ): Response<Message>
}
