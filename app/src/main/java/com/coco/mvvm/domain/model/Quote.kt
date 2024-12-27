package com.coco.mvvm.domain.model

import com.coco.mvvm.data.database.entities.QuoteEntity
import com.coco.mvvm.data.model.QuoteModel

data class Quote(
    val id: Int,
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(
    id = id,
    quote = quote,
    author = author
)

fun QuoteEntity.toDomain() = Quote(
    id = id,
    quote = quote,
    author = author
)
