package com.ams.linkme.networking

import com.ams.linkme.model.*
import com.ams.linkme.utils.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>


    @GET("chat/{userId}/{friendId}")
    suspend fun getMessages(
        @Path("userId") userId: String,
        @Path("friendId") friendId: String
    ): Response<List<Message>>

    @POST("chat/sendMessage")
    suspend fun sendMessage(
        @Body message: Message
    ): Response<Message>


    @GET("/checkUsernameExists")
    suspend fun checkUsernameExists(@Query("username") username: String): Response<Boolean>

}
