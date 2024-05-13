package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.data.entities.UserFavoriteBook

@Dao
interface UserFavoriteBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserFavoriteBook(userFavoriteBook: UserFavoriteBook)

    @Delete
    suspend fun deleteUserFavoriteBook(userFavoriteBook: UserFavoriteBook)

    @Query("SELECT * FROM book INNER JOIN user_favorite_books " +
            "ON book.isbn13 = user_favorite_books.bookId WHERE" +
            " user_favorite_books.userId = :userId")
    suspend fun getFavoriteBooks(userId: Int): List<Book>

    //@Query("SELECT EXISTS (SELECT userId FROM user_favorite_books WHERE bookId = :bookId LIMIT 1)")
    //suspend fun isBookFavorite(userId: Int, bookId: String): Boolean
}