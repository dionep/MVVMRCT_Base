package com.example.mvvmrct_base.model

sealed class Result<out T : Any> {
    class Success<out T : Any>(val data: T) : Result<T>()

    class Error(
        val exception: Throwable,
        val message: String = exception.message ?: "UnknownError"
    ) : Result<Nothing>()

    class Progress(val isLoading: Boolean) : Result<Nothing>()
}