package com.example.mvvmrct_base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmrct_base.Screens
import com.example.mvvmrct_base.entity.TodoModel
import com.example.mvvmrct_base.model.Either
import com.example.mvvmrct_base.model.repository.MainRepository
import com.example.mvvmrct_base.model.system.FlowRouter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val flowRouter: FlowRouter
) : ViewModel() {

    val postsLiveData = MutableLiveData<List<TodoModel>>()
    val errorHandler = MutableLiveData<Throwable>()
    val loadingLiveData = MutableLiveData<Boolean>()

    fun loadPosts() {
        viewModelScope.launch {
            flowOf(mainRepository.getPosts())
                .onStart { loadingLiveData.value = true }
                .onCompletion { loadingLiveData.value = false }
                .collect {
                    when (it) {
                        is Either.Success -> postsLiveData.value = it.data
                    }
                }
        }
    }

    fun goToSms() = flowRouter.navigateTo(Screens.Sms)
    fun goToBack() = flowRouter.exit()
    fun goToService() = flowRouter.navigateTo(Screens.Service)
    fun goToReg() = flowRouter.startFlow(Screens.RegFlow)
    fun goToName() = flowRouter.navigateTo(Screens.Name)
    fun goToSome() = flowRouter.navigateTo(Screens.Some)
    fun exitReg() = flowRouter.finishFlow()
}