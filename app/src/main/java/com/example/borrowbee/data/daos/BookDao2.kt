package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.borrowbee.data.entities.Book

@Dao
interface BookDao2 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book): Long

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM book")
    suspend fun getAllBooks(): List<Book>

    @Query("SELECT * FROM book WHERE isbn13 = :isbn13")
    suspend fun getBookByIsbn13(isbn13: Int): Book?  // Use nullable return type as book may not exist

    // Add additional queries as needed, e.g., by title, author etc.
}