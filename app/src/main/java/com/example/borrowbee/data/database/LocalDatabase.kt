package com.example.borrowbee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.borrowbee.data.daos.BookDao
import com.example.borrowbee.data.daos.UserFavoriteBookDao
import com.example.borrowbee.data.daos.UserRentedBookDao
import com.example.borrowbee.data.entities.Book
import com.example.borrowbee.data.entities.UserFavoriteBook
import com.example.borrowbee.data.entities.UserRentedBook

@Database(entities = [Book::class, UserRentedBook::class, UserFavoriteBook::class], version = 19)
abstract class LocalDatabase : RoomDatabase() {

    companion object{
        const val NAME = "borrowbee_db"
    }

    abstract fun bookDao(): BookDao
    abstract fun rentedDao(): UserRentedBookDao

    abstract fun favoritesDao(): UserFavoriteBookDao



}