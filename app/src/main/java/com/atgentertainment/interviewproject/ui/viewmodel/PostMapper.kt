package com.atgentertainment.interviewproject.ui.viewmodel

import com.atgentertainment.interviewproject.network.model.PostDto
import javax.inject.Inject

data class PostViewData(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)

class PostMapper @Inject constructor() {
    fun map(postListDto: List<PostDto>): List<PostViewData> {
        return postListDto.map { post ->
            PostViewData(
                id = post.id,
                userId = post.userId,
                title = post.title,
                body = post.body,
            )
        }
    }
}