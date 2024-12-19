package com.coco.mvvm.data

import com.coco.mvvm.data.api.QuoteApiService
import com.coco.mvvm.data.model.QuoteModel
import com.coco.mvvm.data.model.QuoteProvider

class QuoteRepository {
    private val quoteService = QuoteApiService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = quoteService.getQuoteService()
        QuoteProvider.quotes = response
        return response
    }
}