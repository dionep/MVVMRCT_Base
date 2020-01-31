package com.example.mvvmrct_base.ui.auth

import com.example.mvvmrct_base.Screens
import com.example.mvvmrct_base.ui.base.BaseFlowFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AuthFlowFragment: BaseFlowFragment() {
    override fun getLaunchScreen(): SupportAppScreen = Screens.Login
}

