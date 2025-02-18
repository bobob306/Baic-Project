package com.atgentertainment.interviewproject.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.atgentertainment.interviewproject.base.ViewData
import com.atgentertainment.interviewproject.ui.viewmodel.PostListScreenViewModel
import com.atgentertainment.interviewproject.ui.viewmodel.PostViewData

@Composable
fun PostListScreen(
    viewModel: PostListScreenViewModel = hiltViewModel<PostListScreenViewModel>(),
) {
    val viewData by viewModel.viewData.collectAsState()
    when (viewData) {
        is ViewData.Success -> {
            val postList = (viewData as ViewData.Success<List<PostViewData>>).data
            PostListContent(postList)
        }

        is ViewData.Error -> {

        }

        is ViewData.Loading -> {

        }
    }
}

@Composable
fun PostListContent(postList: List<PostViewData>) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize(),
        ) {
            items(postList) { post ->
                PostItem(post)
            }
        }
    }
}

@Composable
fun PostItem(post: PostViewData) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = post
                .title
        )
        Text(text = post.body)

    }
}