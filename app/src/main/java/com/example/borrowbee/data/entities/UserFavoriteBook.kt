package com.example.borrowbee.data.entities

import androidx.room.Entity

@Entity(tableName = "user_favorite_books", primaryKeys = ["userId", "bookId"])
data class UserFavoriteBook(
    val userId: Int,
    val bookId: String
)