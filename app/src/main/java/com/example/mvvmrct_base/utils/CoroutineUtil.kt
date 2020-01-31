package com.example.mvvmrct_base.utils

import com.example.mvvmrct_base.model.Either
import retrofit2.Response
import java.lang.Exception

fun <T> Response<T>.getEither(): Either<T> {
    try {
        this.body()?.let {
            return Either.Success(it)
        } ?: return Either.Error(Exception("Data is Null"))
    } catch (e: Throwable) {
        return Either.Error(e)
    }
}
