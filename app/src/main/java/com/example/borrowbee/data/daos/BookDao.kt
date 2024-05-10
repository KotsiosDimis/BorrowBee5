package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.borrowbee.data.entities.BookEntity

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: BookEntity)

    @Query("SELECT COUNT(*) FROM books WHERE title = :title AND author = :author")
    suspend fun countBooksByTitleAndAuthor(title: String, author: String): Int

    @Query("DELETE FROM books")
    suspend fun deleteAllBooks()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBooks(books: List<BookEntity>)

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<BookEntity>


    @Query("SELECT * FROM books WHERE isBestseller = 1")
     fun getBestSellers(): List<BookEntity>


    @Query("SELECT * FROM books")
    fun getAllBooksAsArray(): Array<BookEntity> // Update return type to List<BookEntity>

    // Add other CRUD operations here
    






}


