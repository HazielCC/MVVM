package com.coco.mvvm.data.api

import com.coco.mvvm.core.API
import com.coco.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class QuoteApiService {
    private var retrofit: Retrofit = API.getRetrofit()

    suspend fun getQuoteService(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuote()
            response.body() ?: emptyList()
        }
    }
}
