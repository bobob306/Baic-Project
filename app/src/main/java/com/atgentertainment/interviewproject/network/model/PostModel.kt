package com.atgentertainment.interviewproject.network.model

import kotlinx.serialization.SerialName

data class PostDto(
    @SerialName("userId") val userId: Int,
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("body") val body: String
)