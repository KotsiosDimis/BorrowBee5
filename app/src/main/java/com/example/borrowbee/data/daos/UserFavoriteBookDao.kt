package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.borrowbee.data.entities.UserFavoriteBook

@Dao
interface UserFavoriteBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserFavoriteBook(userFavoriteBook: UserFavoriteBook)

    @Delete
    suspend fun deleteUserFavoriteBook(userFavoriteBook: UserFavoriteBook)

    /*
    @Query("SELECT * FROM user_favorite_books WHERE userId = :userId")
    suspend fun getFavoriteBooksByUserId(userId: Int): List<Book> // This fetches associated Books

    @Query("SELECT * FROM user_favorite_books")
    suspend fun getFavoriteBooks(): List<Book> // This fetches associated Books
*/
    // Add additional queries as needed
}