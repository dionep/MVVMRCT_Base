package com.example.mvvmrct_base.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoModel(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
) : Parcelable