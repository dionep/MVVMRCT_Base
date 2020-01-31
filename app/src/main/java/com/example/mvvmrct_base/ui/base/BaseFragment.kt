package com.example.mvvmrct_base.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.mvvmrct_base.Constants
import com.example.mvvmrct_base.ui.AppActivity
import com.example.mvvmrct_base.utils.objectScopeName
import toothpick.Scope
import toothpick.Toothpick
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private const val STATE_SCOPE_NAME = "state_scope_name"

abstract class BaseFragment : Fragment() {

    abstract val layoutRes: Int

    private var instanceStateSaved: Boolean = false

    protected open val parentScopeName: String by lazy {
        (parentFragment as? BaseFragment)?.fragmentScopeName ?: Constants.Scopes.SERVER_SCOPE
    }

    lateinit var fragmentScopeName: String
    lateinit var scope: Scope
        private set

    protected open fun installModules(scope: Scope) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        fragmentScopeName = savedInstanceState?.getString(STATE_SCOPE_NAME) ?: objectScopeName()

        if (Toothpick.isScopeOpen(fragmentScopeName)) {
            scope = Toothpick.openScope(fragmentScopeName)
        } else {
            scope = Toothpick.openScopes(parentScopeName, fragmentScopeName)
            installModules(scope)
        }

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onResume() {
        super.onResume()
        instanceStateSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        instanceStateSaved = true
        outState.putString(STATE_SCOPE_NAME, fragmentScopeName)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (needCloseScope()) Toothpick.closeScope(scope.name)
    }

    fun isRealRemoving(): Boolean =
        (isRemoving && !instanceStateSaved) || // Because isRemoving == true for fragment in backstack on screen rotation
                ((parentFragment as? BaseFragment)?.isRealRemoving() ?: false)

    private fun needCloseScope(): Boolean =
        when {
            activity?.isChangingConfigurations == true -> false
            activity?.isFinishing == true -> true
            else -> isRealRemoving()
        }

    fun showError(message: String) {
        (activity as? AppActivity)?.showError(message)
    }

    fun showSuccess(message: String) {
        (activity as? AppActivity)?.showSuccess(message)
    }

    fun hideKeyboard() {
        (activity as? AppActivity)?.hideKeyboard()
    }

    open fun onBackPressed() {}

    infix fun <U> LiveData<U>.bindTo(f: (U) -> Unit) {
        observe(this@BaseFragment, Observer { f(it) })
    }

    inline fun <reified T> scope() =
        object : ReadWriteProperty<BaseFragment, T> {

            private var value: Any? = null

            override fun setValue(thisRef: BaseFragment, property: KProperty<*>, value: T) {
                this.value = value
            }

            override fun getValue(thisRef: BaseFragment, property: KProperty<*>): T {
                if (value == null) {
                    val instance = thisRef.scope.getInstance(T::class.java)
                    check(instance != null && instance is T) { "Property is null or has different class type" }
                    value = instance
                }
                return value as T
            }
        }

}