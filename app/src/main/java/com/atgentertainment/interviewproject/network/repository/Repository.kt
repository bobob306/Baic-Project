package com.atgentertainment.interviewproject.network.repository

import com.atgentertainment.interviewproject.network.RetrofitApi
import com.atgentertainment.interviewproject.network.model.PostDto
import javax.inject.Inject


interface Repository {
    suspend fun getPostList(): List<PostDto>
}

class RepositoryImpl @Inject constructor(
    private val retrofitApi: RetrofitApi,
) : Repository {
    private var cachedPosts: List<PostDto>? = null

    override suspend fun getPostList(): List<PostDto> {
        return retrofitApi.getPostList()
    }
}