package com.example.mvvmrct_base.utils

import android.view.View

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun View.setInisible() {
    visibility = View.INVISIBLE
}

fun View.setLoadingState(isLoading: Boolean) {
    visibility = if (isLoading) View.VISIBLE else View.GONE
}

infix fun View.setLoading(isLoading: Boolean) {
    visibility = if (isLoading) View.VISIBLE else View.GONE
}

fun Any.objectScopeName() = "${javaClass.simpleName}_${hashCode()}"