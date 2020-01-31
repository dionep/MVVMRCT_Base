package com.example.mvvmrct_base.network.service

import com.example.mvvmrct_base.entity.TodoModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/todos")
    suspend fun getTodos() : Response<List<TodoModel>>

}