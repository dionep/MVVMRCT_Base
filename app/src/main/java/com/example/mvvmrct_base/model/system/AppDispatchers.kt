package com.example.mvvmrct_base.model.system

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AppDispatchers(
    private val dispatchers: Dispatchers
) : DispatchersProvider {
    override fun io()= dispatchers.IO
    override fun ui() = dispatchers.Main
    override fun default() = dispatchers.Default
    override fun unconfined() = dispatchers.Unconfined
}