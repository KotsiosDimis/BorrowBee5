package com.example.borrowbee.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.borrowbee.data.daos.BookDao
import com.example.borrowbee.data.daos.StoreBookDao
import com.example.borrowbee.data.entities.BookEntity
import com.example.borrowbee.data.entities.StoreBookEntity

@Database(entities = [BookEntity::class, StoreBookEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun storeBookDao(): StoreBookDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}