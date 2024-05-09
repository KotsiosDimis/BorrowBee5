package com.example.borrowbee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.borrowbee.data.daos.BookDao
import com.example.borrowbee.data.daos.StoreBookDao
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.entities.StoreBookEntity

@Database(entities = [BookEntity::class, StoreBookEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    companion object{
        const val NAME = "borrowbee_db"
    }

    abstract fun bookDao(): BookDao
    abstract fun storeBookDao(): StoreBookDao



}