package com.example.borrowbee.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.borrowbee.R
import com.example.borrowbee.data.models.BookModel

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val author: String,
    val bookImage: Int = R.drawable.book_to_the_moon, // Default book image
    val backgroundColor: String = "#36A0B5", // Default background color
    val bookProgress: Float = 0f,
    val isBestseller: Boolean = false
    //val genreId: Long
){
    constructor(
        title: String,
        author: String,
        bookProgress: Float = 0f,
        isBestseller: Boolean = false,
        id: Long = 0 // id should come last
    ) : this(id, title, author, R.drawable.book_to_the_moon, "#36A0B5", bookProgress, isBestseller)
}

fun BookEntity.toBookModel(): BookModel {
    return BookModel(
        title = title,
        author = author,
        bookImage = bookImage,
        backgroundColor = "#36A0B5", // Default background color
        bookProgress = bookProgress
    )
}


