package com.coco.mvvm.data

import com.coco.mvvm.data.api.QuoteApiService
import com.coco.mvvm.data.model.QuoteModel
import com.coco.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: QuoteApiService,
    private val quoteProvider: QuoteProvider
) {
    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = quoteService.getQuoteService()
        quoteProvider.quotes = response
        return response
    }
}