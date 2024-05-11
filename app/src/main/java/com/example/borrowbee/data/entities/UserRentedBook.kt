package com.example.borrowbee.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_rented_books")
data class UserRentedBook(
    @PrimaryKey
    val transctionId: Int,
    val userId: Int,
    val bookId: Int,
    val rentedDate: String,
    val returnedDate: String? = null
)