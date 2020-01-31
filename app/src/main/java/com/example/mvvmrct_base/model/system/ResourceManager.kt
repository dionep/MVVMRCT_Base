package com.example.mvvmrct_base.model.system

import android.content.Context
import javax.inject.Inject

class ResourceManager @Inject constructor(
    private val context: Context
) {
    fun getString(resId: Int) = context.resources.getString(resId)
}