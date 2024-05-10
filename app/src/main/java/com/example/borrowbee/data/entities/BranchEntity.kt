package com.example.borrowbee.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "branches")
data class BranchEntity(
    @PrimaryKey
    @ColumnInfo(name = "branch_id")
    val branchId: Long = 0L,

    @ColumnInfo(name = "branch_name")
    val branchName: String,

    val location: String
)
