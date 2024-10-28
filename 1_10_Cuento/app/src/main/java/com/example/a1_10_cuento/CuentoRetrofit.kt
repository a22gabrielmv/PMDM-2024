package com.example.a1_10_cuento

import ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIApi {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer sk-svcacct-N2GkER-wqvEuOsYBh4v07MmrpIt1ceIkNwZp1iP23RJkOC89M5PhVXKweElT3BlbkFJBzPvl8HlYQnnjNOBe-bYtX8IEk4sP1JrTNmW5InPQsMsgzn1Ph-nZcKHcAA"
    )
    @POST("v1/chat/completions")
    fun getChatResponse(@Body request: ChatRequest): Call<ChatResponse>
}
