package com.example.mvvmrct_base.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmrct_base.model.repository.BaseRepository

abstract class BaseViewMode(
    private vararg val repositories: BaseRepository
): ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}