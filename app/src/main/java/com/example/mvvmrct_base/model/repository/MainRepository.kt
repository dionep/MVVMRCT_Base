package com.example.mvvmrct_base.model.repository

import com.example.mvvmrct_base.model.Result
import com.example.mvvmrct_base.network.service.ApiService
import com.example.mvvmrct_base.utils.applySideEffects
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) : BaseRepository() {

    @ExperimentalCoroutinesApi
    fun getPosts() = flow { emit(getForecastFromApi()) }
        .applySideEffects()

    private suspend fun getForecastFromApi() = apiService.getTodos()
        .run {
            if (isSuccessful && body() != null) {
                Result.Success(body()!!)
            } else {
                Result.Error(Throwable("SOME FAILURE"))
            }
        }

//        withContext(dispatchersProvider.io()) { apiService.getTodos().getEither() }

}
