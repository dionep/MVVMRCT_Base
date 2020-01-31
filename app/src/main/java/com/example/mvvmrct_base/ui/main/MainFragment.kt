package com.example.mvvmrct_base.ui.main

import android.os.Bundle
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.Screens
import com.example.mvvmrct_base.ui.base.BaseFlowFragment
import com.example.mvvmrct_base.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.terrakok.cicerone.android.support.SupportAppScreen

class MainFragment : BaseFragment() {

    private val authTab by lazy { Screens.AuthFlow }
    private val pipTab by lazy { Screens.PipFlow }

    override val layoutRes: Int
        get() = R.layout.fragment_main

    private val currentTabFragment: BaseFlowFragment?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as? BaseFlowFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottomBar.selectedItemId = R.id.auth
        bottomBar.setOnNavigationItemSelectedListener {
            selectTab(
                when(it.itemId) {
                    R.id.auth -> authTab
                    R.id.pip -> pipTab
                    else -> authTab
                }
            )
            true
        }
        selectTab(
            when(currentTabFragment?.tag) {
                authTab.screenKey -> authTab
                pipTab.screenKey -> pipTab
                else -> authTab
            }
        )
    }

    private fun selectTab(tab: SupportAppScreen) {
        val currentFragment = currentTabFragment
        val newFragment = childFragmentManager.findFragmentByTag(tab.screenKey)
        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return
        childFragmentManager.beginTransaction().apply {
            if (newFragment == null) add(R.id.mainScreenContainer, tab.fragment, tab.screenKey)
            currentFragment?.let {
                hide(it)
                it.userVisibleHint = false
            }
            newFragment?.let {
                show(it)
                it.userVisibleHint = true
            }
        }.commitNow()
    }

    override fun onBackPressed() {
        currentTabFragment?.onBackPressed()
    }


}