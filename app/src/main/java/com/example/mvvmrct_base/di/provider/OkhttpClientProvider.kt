package com.example.mvvmrct_base.di.provider

import android.content.Context
import com.example.mvvmrct_base.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor(
    private val context: Context
) : Provider<OkHttpClient> {

    override fun get(): OkHttpClient = with(OkHttpClient.Builder()) {
        cache(Cache(context.cacheDir, CACHE_SIZE_BYTES))
        connectTimeout(TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
        readTimeout(TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            addNetworkInterceptor(
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            )
        }
        build()
    }

    companion object {
        private const val CACHE_SIZE_BYTES = 20 * 1024L
        private const val TIMEOUT = 100L
    }
}