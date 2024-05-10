package com.example.borrowbee.main

import android.app.Application
import androidx.room.Room
import com.example.borrowbee.data.database.LocalDatabase

class MainApplication : Application() {
    companion object {
       lateinit var localDatabase: LocalDatabase
    }

    override fun onCreate() {
        super.onCreate()
        localDatabase = Room.databaseBuilder(
            applicationContext,
            LocalDatabase::class.java,
            LocalDatabase.NAME
        ).fallbackToDestructiveMigration().build()
    }

}