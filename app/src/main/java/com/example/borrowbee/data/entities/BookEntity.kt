package com.example.borrowbee.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.borrowbee.R
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "books")
data class BookEntity (
    @PrimaryKey(autoGenerate = false)
    val isbn13: Long = 9000000000000,
    val title: String,
    val author: String,
    val bookImage: Int = R.drawable.book_to_the_moon, // Default book image
    val backgroundColor: String = "#36A0B5", // Default background color
    val isBestseller: Boolean = false
) : Parcelable {
}

