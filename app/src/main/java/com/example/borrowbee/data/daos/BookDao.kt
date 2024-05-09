package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.borrowbee.data.entities.BookEntity

@Dao
interface BookDao {
    @Upsert
    fun insert(book: BookEntity)

    @Upsert
    fun insertAll(books: List<BookEntity>)

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<BookEntity>


    @Query("SELECT * FROM books WHERE isBestseller = 1")
     fun getBestSellers(): List<BookEntity>


    @Query("SELECT * FROM books")
    fun getAllBooksAsArray(): Array<BookEntity> // Update return type to List<BookEntity>

    // Add other CRUD operations here
    
    @Query("SELECT * FROM books WHERE id = 1")
    fun get1Book(): BookEntity





}


