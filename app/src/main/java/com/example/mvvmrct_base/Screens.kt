package com.example.mvvmrct_base

import androidx.fragment.app.Fragment
import com.example.mvvmrct_base.ui.auth.AuthFlowFragment
import com.example.mvvmrct_base.ui.auth.LoginFragment
import com.example.mvvmrct_base.ui.auth.SmsFragment
import com.example.mvvmrct_base.ui.main.MainFragment
import com.example.mvvmrct_base.ui.pip.MenuFragment
import com.example.mvvmrct_base.ui.pip.PipFlowFragment
import com.example.mvvmrct_base.ui.pip.ServiceFragment
import com.example.mvvmrct_base.ui.pip.reg.NameFragment
import com.example.mvvmrct_base.ui.pip.reg.RegFlowFragment
import com.example.mvvmrct_base.ui.pip.reg.RegFragment
import com.example.mvvmrct_base.ui.pip.reg.SomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Main: SupportAppScreen() {
        override fun getFragment(): Fragment = MainFragment()
    }

    object PipFlow: SupportAppScreen() {
        override fun getFragment(): Fragment = PipFlowFragment()
    }

    object AuthFlow: SupportAppScreen() {
        override fun getFragment(): Fragment = AuthFlowFragment()
    }

    object Login: SupportAppScreen() {
        override fun getFragment(): Fragment = LoginFragment()
    }

    object Sms: SupportAppScreen() {
        override fun getFragment(): Fragment = SmsFragment()
    }

    object Menu: SupportAppScreen() {
        override fun getFragment(): Fragment = MenuFragment()
    }

    object Service: SupportAppScreen() {
        override fun getFragment(): Fragment = ServiceFragment()
    }

    object Reg: SupportAppScreen() {
        override fun getFragment(): Fragment = RegFragment()
    }

    object RegFlow: SupportAppScreen() {
        override fun getFragment(): Fragment = RegFlowFragment()
    }

    object Name: SupportAppScreen() {
        override fun getFragment(): Fragment = NameFragment()
    }

    object Some: SupportAppScreen() {
        override fun getFragment(): Fragment = SomeFragment()
    }
}