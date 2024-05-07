package com.example.borrowbee.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store_books")
data class StoreBookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val storeId: Long,
    val bookId: Long,
    val copies: Int // Number of copies of the book in the store
)