package com.coco.mvvm.data.api

import com.coco.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteApiService @Inject constructor(
    private val apiClient: QuoteApiClient
) {
    suspend fun getQuoteService(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllQuote()
            response.body() ?: emptyList()
        }
    }
}
