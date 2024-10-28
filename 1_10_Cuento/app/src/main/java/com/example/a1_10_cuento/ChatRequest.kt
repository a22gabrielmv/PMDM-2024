package com.example.a1_10_cuento

data class ChatRequest(
    val model: String,
    val messages: List<Message>
) {
    data class Message(
        val role: String,
        val content: String
    )
}
