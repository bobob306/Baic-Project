package com.atgentertainment.interviewproject.network

import com.atgentertainment.interviewproject.network.model.PostDto
import retrofit2.http.GET

interface RetrofitApi {
    @GET("posts")
    suspend fun getPostList(): List<PostDto>
}