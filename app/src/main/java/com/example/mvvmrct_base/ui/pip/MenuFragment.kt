package com.example.mvvmrct_base.ui.pip

import android.os.Bundle
import android.view.View
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.entity.TodoModel
import com.example.mvvmrct_base.model.Result
import com.example.mvvmrct_base.ui.base.BaseFragment
import com.example.mvvmrct_base.utils.setLoading
import com.example.mvvmrct_base.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment: BaseFragment() {

    private val viewModel by scope<MainViewModel>()

    override val layoutRes: Int
        get() = R.layout.fragment_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonMenu.setOnClickListener { viewModel.goToService() }
        buttonGet.setOnClickListener { viewModel.loadPosts() }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViewModelObservers()
    }

    private fun setUpViewModelObservers() {
        viewModel.postsLiveData bindTo { handleResponse(it) }
    }

    private fun handleResponse(result: Result<List<TodoModel>>?) {
        when(result) {
            is Result.Success -> tv_data.text = result.data.first().title
            is Result.Error -> showError(result.message)
            is Result.Progress -> pb_loading setLoading result.isLoading
        }
    }

}