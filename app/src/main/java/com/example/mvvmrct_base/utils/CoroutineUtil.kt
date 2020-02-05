package com.example.mvvmrct_base.utils

import com.example.mvvmrct_base.model.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

fun <T: Any> Flow<Result<T>>.applySideEffects() =
    onStart { emit(Result.Progress(isLoading = true)) }
        .onCompletion { emit(Result.Progress(isLoading = false)) }
        .catch { emit(Result.Error(it)) }

