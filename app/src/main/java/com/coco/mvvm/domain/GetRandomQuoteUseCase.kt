package com.coco.mvvm.domain

import com.coco.mvvm.data.model.QuoteModel
import com.coco.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {
    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = quoteProvider.quotes
        if (quotes.isNotEmpty()) {
            val random = quotes.indices.random()
            return quotes[random]
        }
        return null
    }
}