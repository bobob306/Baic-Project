package com.atgentertainment.interviewproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atgentertainment.interviewproject.base.ViewData
import com.atgentertainment.interviewproject.network.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListScreenViewModel @Inject constructor(
    private val repository: Repository,
    private val mapper: PostMapper,
) : ViewModel() {
    private var _viewData = MutableStateFlow<ViewData<List<PostViewData>>>(ViewData.Loading())
    val viewData: StateFlow<ViewData<List<PostViewData>>> = _viewData

    init {
        viewModelScope.launch {
            try {
                val postListDto = repository.getPostList()
                val postListViewData = mapper.map(postListDto)
                _viewData.value = ViewData.Success(postListViewData)
            } catch (e: Exception) {
                _viewData.value = ViewData.Error(e.message ?: "Unknown error")
            }
        }
    }
}