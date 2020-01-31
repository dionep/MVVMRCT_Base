package com.example.mvvmrct_base.ui.pip.reg

import android.os.Bundle
import android.view.View
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.ui.base.BaseFragment
import com.example.mvvmrct_base.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_reg.*

class RegFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_reg

    private val viewModel by scope<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backB.setOnClickListener { viewModel.goToBack() }
        buttonReg.setOnClickListener { viewModel.goToName() }
    }
}