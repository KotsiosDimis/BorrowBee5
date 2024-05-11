package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.borrowbee.data.entities.UserRentedBook

@Dao
interface UserRentedBookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserRentedBook(userRentedBook: UserRentedBook)

    @Update
    suspend fun updateUserRentedBook(userRentedBook: UserRentedBook)

    @Delete
    suspend fun deleteUserRentedBook(userRentedBook: UserRentedBook)

    @Query("SELECT * FROM user_rented_books WHERE userId = :userId")
    suspend fun getRentedBooksByUserId(userId: Int): List<UserRentedBook>  // Includes rentedDate and returnedDate

    // Add additional queries as needed, e.g., check availability
}