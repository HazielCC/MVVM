package com.coco.mvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coco.mvvm.data.database.dao.QuoteDao
import com.coco.mvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}