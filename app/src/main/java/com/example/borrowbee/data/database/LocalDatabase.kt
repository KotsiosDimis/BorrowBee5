package com.example.borrowbee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.borrowbee.data.daos.BookAvailabilityDao
import com.example.borrowbee.data.daos.BookDao
import com.example.borrowbee.data.daos.BranchDao
import com.example.borrowbee.data.entities.BookAvailabilityEntity
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.entities.BranchEntity

@Database(entities = [BookEntity::class, BookAvailabilityEntity::class, BranchEntity::class], version = 4)
abstract class LocalDatabase : RoomDatabase() {

    companion object{
        const val NAME = "borrowbee_db"
    }

    abstract fun bookDao(): BookDao
    abstract fun bookAvailabilityDao(): BookAvailabilityDao

    abstract fun brunchDao(): BranchDao



}