package com.example.mvvmrct_base

import android.app.Application
import com.example.mvvmrct_base.di.Scopes
import com.example.mvvmrct_base.di.modules.AppModule
import com.example.mvvmrct_base.di.modules.ServerModule
import toothpick.Toothpick
import toothpick.configuration.Configuration

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initToothpick()
    }

    private fun initToothpick() {
        Toothpick.setConfiguration(
            if (BuildConfig.DEBUG) Configuration.forDevelopment().preventMultipleRootScopes() else Configuration.forProduction()
        )

        Toothpick.openScope(Scopes.APP_SCOPE)
            .installModules(
                AppModule(this),
                ServerModule()
            )
    }
}