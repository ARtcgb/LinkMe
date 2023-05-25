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
class MessageAdapter(private val messages: MutableList<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    /**
     * ViewHolder class for the Message item.
     */
    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sender: TextView = view.findViewById(R.id.text_view_sender)
        val content: TextView = view.findViewById(R.id.text_view_content)

        /**
         * Binds the message data to the views.
         *
         * @param message The Message object containing the data to be displayed.
         */
        fun bind(message: Message) {
            sender.text = message.sender
            content.text = message.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount() = messages.size

    /**
     * Function to add a message to the list and notify the adapter.
     *
     * @param message The Message object to be added.
     */
    fun addMessage(message: Message) {
        messages.add(message)
        notifyItemInserted(messages.size - 1)
    }
}
