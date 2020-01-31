package com.example.mvvmrct_base.ui.pip.reg

import android.os.Bundle
import android.view.View
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.ui.base.BaseFragment
import com.example.mvvmrct_base.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_name.*

class NameFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_name

    private val viewModel by scope<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backS.setOnClickListener { viewModel.goToBack() }
        buttonName.setOnClickListener { viewModel.goToSome() }
    }
}