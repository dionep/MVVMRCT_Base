package com.example.mvvmrct_base.ui.pip

import com.example.mvvmrct_base.Screens
import com.example.mvvmrct_base.ui.base.BaseFlowFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class PipFlowFragment: BaseFlowFragment() {
    override fun getLaunchScreen(): SupportAppScreen = Screens.Menu
}