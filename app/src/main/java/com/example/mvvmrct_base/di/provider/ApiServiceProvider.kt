package com.example.mvvmrct_base.di.provider

import com.example.mvvmrct_base.Constants.Api.BASE_URL
import com.example.mvvmrct_base.network.service.ApiService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Provider

class ApiServiceProvider @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val gson: Gson
): Provider<ApiService> {
    override fun get(): ApiService = with(Retrofit.Builder()) {
        addConverterFactory(GsonConverterFactory.create(gson))
        client(okHttpClient)
        baseUrl(BASE_URL)
        build().create(ApiService::class.java)
    }
}