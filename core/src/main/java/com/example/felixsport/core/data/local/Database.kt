package com.example.felixsport.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SportRoom::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase(){
    abstract fun roomDao(): RoomDao
}