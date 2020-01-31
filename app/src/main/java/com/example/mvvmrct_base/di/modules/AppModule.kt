package com.example.mvvmrct_base.di.modules

import android.content.Context
import com.example.mvvmrct_base.di.provider.GsonProvider
import com.example.mvvmrct_base.model.system.AppDispatchers
import com.example.mvvmrct_base.model.system.DispatchersProvider
import com.example.mvvmrct_base.model.system.ResourceManager
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class AppModule(context: Context): Module() {
    init {
//        bind(String::class.java).withName(DefaultServerPath::class.java).toInstance(Constants.BaseUrl.PROD)
        bind(Context::class.java).toInstance(context)
        bind(Gson::class.java).toProvider(GsonProvider::class.java).providesSingletonInScope()
        bind(ResourceManager::class.java).singletonInScope()
        // navigation
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
        bind(DispatchersProvider::class.java).toInstance(AppDispatchers(Dispatchers))
    }
}
