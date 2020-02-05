package com.example.mvvmrct_base.viewmodel

import com.example.mvvmrct_base.entity.TodoModel
import com.example.mvvmrct_base.model.repository.MainRepository
import com.example.mvvmrct_base.network.service.ApiService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTests {

    private val mainRepository: MainRepository = mock()
    private val mockTodo = TodoModel(
        id = 32,
        userId = 33,
        title = "sss",
        completed = false
    )
    private val mockViewModel: MainViewModel = mock()
    private val apiService: ApiService = mock()
    private val testDispatcher = TestCoroutineDispatcher()
    private val managedCoroutineScope = TestCoroutineScope(testDispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `loadPosts should return list`() {


        assert(mockViewModel.postsLiveData.value == listOf(mockTodo, mockTodo))
    }

}