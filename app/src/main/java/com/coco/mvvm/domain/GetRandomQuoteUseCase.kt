package com.coco.mvvm.domain

import com.coco.mvvm.data.model.QuoteModel
import com.coco.mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if (quotes.isNotEmpty()) {
            val random = quotes.indices.random()
            return quotes[random]
        }
        return null
    }
}