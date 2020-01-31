package com.example.mvvmrct_base.di.modules

import com.example.mvvmrct_base.di.provider.ApiServiceProvider
import com.example.mvvmrct_base.di.provider.OkHttpClientProvider
import com.example.mvvmrct_base.network.service.ApiService
import okhttp3.OkHttpClient
import toothpick.config.Module

class ServerModule : Module() {
    init {
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java).providesSingletonInScope()
        bind(ApiService::class.java).toProvider(ApiServiceProvider::class.java).providesSingletonInScope()
    }
}