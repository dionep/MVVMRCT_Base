package com.example.mvvmrct_base.ui.auth

import android.os.Bundle
import android.view.View
import com.example.mvvmrct_base.R
import com.example.mvvmrct_base.ui.base.BaseFragment
import com.example.mvvmrct_base.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_sms.*

class SmsFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_sms

    private val viewModel by scope<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSms.setOnClickListener { viewModel.goToBack() }
    }

    override fun onBackPressed() {
        viewModel.goToBack()
    }
}