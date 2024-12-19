package com.coco.mvvm.data.api

import com.coco.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("quotes")
    suspend fun getAllQuote(): Response<List<QuoteModel>>
}