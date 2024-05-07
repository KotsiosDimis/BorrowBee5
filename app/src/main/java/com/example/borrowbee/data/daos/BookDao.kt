package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.borrowbee.data.entities.BookEntity

@Dao
interface BookDao {
    @Upsert
    suspend fun insert(book: BookEntity)

    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<BookEntity>

    @Upsert
    suspend fun insertAll(books: List<BookEntity>)

    @Query("SELECT * FROM books WHERE isBestseller = 1")
    suspend fun getBestSellers(): List<BookEntity>

    //fun getAllBooks3(): List<BookEntity>

    @Query("SELECT * FROM books")
    fun getAllBooks2(): List<BookEntity> // Update return type to List<BookEntity>

    // Add other CRUD operations here
    
    @Query("SELECT * FROM books WHERE id = 1")
    fun get1Book(): BookEntity
    abstract fun get1book(): Any
}


