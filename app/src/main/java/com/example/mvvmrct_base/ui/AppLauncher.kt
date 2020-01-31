package com.example.mvvmrct_base.ui

import com.example.mvvmrct_base.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AppLauncher @Inject constructor(
    private val router: Router
) {
    fun openMain() {
        router.newRootScreen(Screens.Main)
    }
}