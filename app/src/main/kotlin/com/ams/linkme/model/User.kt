package com.ams.linkme.model

import kotlinx.serialization.Serializable

/**
 * User model that represents a user in the application.
 *
 * @param id unique identifier for each user.
 * @param username the user's username.
 * @param avatarUrl the url of the user's avatar.
 */
@Serializable
data class User(
    val id: String,
    var username: String,
    var avatarUrl: String
)
