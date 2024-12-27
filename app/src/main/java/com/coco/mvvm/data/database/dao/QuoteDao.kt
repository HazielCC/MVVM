package com.coco.mvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coco.mvvm.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {
    /*
    * DAO (Data Access Object):
    * Un DAO es una interfaz que contiene métodos para acceder a la base de datos. Utiliza anotaciones como @Insert, @Update, @Delete, y @Query.
    * Esta interfaz es donde defines las operaciones de base de datos que necesitas realizar.
    */

    // Define the methods to access the database
    @Query("SELECT * FROM quote_table ORDER BY id DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    // Insert the data into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: List<QuoteEntity>)

    // Delete all quotes from the database
    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()
    
}