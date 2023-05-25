package com.ams.linkme.model

import kotlinx.serialization.Serializable

/**
 * Message model that represents a message in a chat.
 *
 * @param senderId unique identifier for the sender.
 * @param receiverId unique identifier for the receiver.
 * @param content the content of the message.
 * @param timestamp the timestamp of the message.
 */
@Serializable
data class Message(
    val senderId: String,
    val receiverId: String,
    var content: String,
    var timestamp: Long
)
