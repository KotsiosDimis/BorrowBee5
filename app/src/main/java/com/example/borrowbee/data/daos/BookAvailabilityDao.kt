package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.borrowbee.data.entities.BookAvailabilityEntity

@Dao
interface BookAvailabilityDao {
    @Query("SELECT * FROM book_availability")
    fun getAllBookAvailabilities(): List<BookAvailabilityEntity>

    @Query("SELECT * FROM book_availability WHERE availability_id = :availabilityId")
    fun getBookAvailabilityById(availabilityId: Long): BookAvailabilityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookAvailability(bookAvailability: BookAvailabilityEntity)

    @Delete
    fun deleteBookAvailability(bookAvailability: BookAvailabilityEntity)
}