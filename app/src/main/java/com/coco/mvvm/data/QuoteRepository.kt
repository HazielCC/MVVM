package com.coco.mvvm.data

import com.coco.mvvm.data.api.QuoteApiService
import com.coco.mvvm.data.database.dao.QuoteDao
import com.coco.mvvm.data.database.entities.QuoteEntity
import com.coco.mvvm.domain.model.Quote
import com.coco.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: QuoteApiService,
    private val quoteDao: QuoteDao
) {
    // From the API
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = quoteService.getQuoteService()
        return response.map { it.toDomain() }
    }

    // From the DB
    suspend fun getAllQuotesFromDb(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    // Save to the DB
    suspend fun saveQuotesToDb(quotes: List<QuoteEntity>) {
        quoteDao.insertQuote(quotes)
    }

    // delete all quotes from the DB
    suspend fun deleteAllQuotesFromDb() {
        quoteDao.deleteAllQuotes()
    }
}