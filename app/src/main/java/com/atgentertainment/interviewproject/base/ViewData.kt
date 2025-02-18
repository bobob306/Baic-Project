package com.atgentertainment.interviewproject.base

sealed class ViewData<T> {
    data class Success<T>(val data: T) : ViewData<T>()
    data class Error<T>(val message: String) : ViewData<T>()
    class Loading<T>(val isLoading: Boolean = true) : ViewData<T>()

}