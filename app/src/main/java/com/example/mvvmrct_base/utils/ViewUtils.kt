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

fun Any.objectScopeName() = "${javaClass.simpleName}_${hashCode()}"