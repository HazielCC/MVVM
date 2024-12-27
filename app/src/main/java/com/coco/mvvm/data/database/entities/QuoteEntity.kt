package com.coco.mvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coco.mvvm.domain.model.Quote

// Define the table name
@Entity(tableName = "quote_table")
data class QuoteEntity(
    // Define the column name

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)

fun Quote.toDataBase() = QuoteEntity(
    id = id,
    quote = quote,
    author = author
)