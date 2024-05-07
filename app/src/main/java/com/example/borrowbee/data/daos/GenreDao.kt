package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.borrowbee.data.entities.BookGenreCrossRef
import com.example.borrowbee.data.entities.GenreEntity

@Dao
interface GenreDao {
    @Upsert
    suspend fun insert(genre: GenreEntity)

    @Query("SELECT * FROM genres")
    suspend fun getAllGenres(): List<GenreEntity>

    // Add other CRUD operations here
}

@Dao
interface BookGenreCrossRefDao {
    @Upsert
    suspend fun insert(bookGenreCrossRef: BookGenreCrossRef)

    // Add other CRUD operations here
}
