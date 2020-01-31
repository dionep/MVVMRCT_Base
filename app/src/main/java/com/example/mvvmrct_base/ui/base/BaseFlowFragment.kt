package com.example.mvvmrct_base.ui.base

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.Screens
import com.example.mvvmrct_base.di.modules.FlowNavigationModule
import com.example.mvvmrct_base.model.system.setLaunchScreen
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command
import toothpick.Scope
import toothpick.Toothpick

abstract class BaseFlowFragment : BaseFragment() {

    override val layoutRes: Int = R.layout.layout_container

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    lateinit var navigatorHolder: NavigatorHolder
    lateinit var router: Router

    override fun installModules(scope: Scope) {
        super.installModules(scope)
        scope.installModules(FlowNavigationModule(scope.getInstance(Router::class.java)))
        router = scope.getInstance(Router::class.java)
        navigatorHolder = scope.getInstance(NavigatorHolder::class.java)
    }

    private val navigator: Navigator by lazy {
        object : SupportAppNavigator(this.activity, childFragmentManager, R.id.container) {
            override fun activityBack() {
                router.exit()
            }

            override fun setupFragmentTransaction(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction
            ) {
                fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
                fragmentTransaction.setReorderingAllowed(true)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toothpick.inject(this, scope)
        if(childFragmentManager.fragments.isEmpty()) navigator.setLaunchScreen(getLaunchScreen())
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    abstract fun getLaunchScreen(): SupportAppScreen

}