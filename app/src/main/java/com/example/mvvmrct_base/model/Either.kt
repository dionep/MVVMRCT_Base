package com.example.mvvmrct_base.model

sealed class Either<T> {
    data class Success<T>(val data: T): Either<T>()
    data class Error<T>(val throwable: Throwable): Either<T>()
}