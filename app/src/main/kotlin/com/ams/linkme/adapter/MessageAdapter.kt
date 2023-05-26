package com.ams.linkme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ams.linkme.R
import com.ams.linkme.model.Message

/**
 * MessageAdapter is a RecyclerView adapter for displaying a list of messages.
 *
 * It takes a list of Message objects and binds their data to the corresponding views.
 */
class MessageAdapter(private val messages: MutableList<Message>)