package com.example.borrowbee.data.models


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BookModel(
    val title: String,
    val author: String,
    val bookImage: Int,
    val backgroundColor: String,
    val bookProgress: Float = 0f
): Parcelable
