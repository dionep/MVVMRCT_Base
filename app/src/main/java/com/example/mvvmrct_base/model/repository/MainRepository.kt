package com.example.mvvmrct_base.model.repository

import com.example.mvvmrct_base.model.system.DispatchersProvider
import com.example.mvvmrct_base.utils.getEither
import com.example.mvvmrct_base.network.service.ApiService
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val dispatchersProvider: DispatchersProvider
) : BaseRepository() {

    suspend fun getPosts() = withContext(dispatchersProvider.io()) { apiService.getTodos().getEither() }

}
