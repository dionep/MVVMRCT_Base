package com.example.mvvmrct_base.ui.pip

import android.os.Bundle
import android.view.View
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.ui.base.BaseFragment
import com.example.mvvmrct_base.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_service.*

class ServiceFragment : BaseFragment() {

    private val viewModel by scope<MainViewModel>()

    override val layoutRes: Int
        get() = R.layout.fragment_service

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonService.setOnClickListener { viewModel.goToReg() }
        back.setOnClickListener { viewModel.goToBack() }
    }
}