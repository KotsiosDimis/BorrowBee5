package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.borrowbee.data.entities.StoreBookEntity

@Dao
interface StoreBookDao {
    @Upsert
    suspend fun insert(storeBook: StoreBookEntity)

    @Query("SELECT * FROM store_books WHERE storeId = :storeId AND bookId = :bookId")
    suspend fun getStoreBook(storeId: Long, bookId: Long): StoreBookEntity?

    // Add other CRUD operations here
}