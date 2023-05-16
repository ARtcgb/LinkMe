package com.ams.linkme.networking

import com.ams.linkme.model.User
import com.ams.linkme.model.Message
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body

/**
 * ApiService interface that defines the HTTP operations.
 */
interface ApiService {

    /**
     * Gets a User by its id.
     *
     * @param id The id of the user.
     * @return The User object.
     */
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): User

    /**
     * Sends a message.
     *
     * @param message The Message object.
     * @return The Message object that was sent.
     */
    @POST("messages")
    suspend fun sendMessage(@Body message: Message): Message

    // ... other HTTP operations ...
}
