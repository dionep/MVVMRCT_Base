package com.example.mvvmrct_base.viewmodel

data class Event<T>(
    val state: EventState = EventState.LOADING,
    val data: T? = null,
    val error: Throwable? = null,
    val isLoading: Boolean = false
)

enum class EventState{
    SUCCESS, ERROR, LOADING
}