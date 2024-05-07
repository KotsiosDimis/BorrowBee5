package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.borrowbee.data.entities.StoreEntity

@Dao
interface StoreDao {
    @Upsert
    suspend fun insert(store: StoreEntity)

    @Query("SELECT * FROM stores")
    suspend fun getAllStores(): List<StoreEntity>

    // Add other CRUD operations here
}
