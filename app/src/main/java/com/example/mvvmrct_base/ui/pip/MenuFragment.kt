package com.example.mvvmrct_base.ui.pip

import android.os.Bundle
import android.util.Log.d
import android.view.View
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.ui.base.BaseFragment
import com.example.mvvmrct_base.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment: BaseFragment() {

    private val viewModel by scope<MainViewModel>()

    override val layoutRes: Int
        get() = R.layout.fragment_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonMenu.setOnClickListener { viewModel.goToService() }
        observePosts()
        buttonGet.setOnClickListener { viewModel.loadPosts() }
    }

    private fun observePosts() {
        viewModel.postsLiveData bindTo { tv_data.text = it.first().title }
        viewModel.loadingLiveData bindTo {
            d("rere", it.toString())
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        }

    }

}