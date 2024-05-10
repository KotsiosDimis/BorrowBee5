package com.example.borrowbee.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_availability")
data class BookAvailabilityEntity(
    @PrimaryKey
    @ColumnInfo(name = "availability_id")
    val availabilityId: Long = 0L,

    @ColumnInfo(name = "book_id")
    val bookId: Long,

    @ColumnInfo(name = "branch_id")
    val branchId: Long,

    @ColumnInfo(name = "available_quantity")
    val availableQuantity: Int
)
