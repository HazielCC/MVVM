package com.coco.mvvm.domain

import com.coco.mvvm.data.QuoteRepository
import com.coco.mvvm.domain.model.Quote
import javax.inject.Inject

// UseCase para obtener una cita aleatoria
class GetRandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend operator fun invoke(): Quote? {
        val quotes: List<Quote> = quoteRepository.getAllQuotesFromDb()
        if (quotes.isNotEmpty()) {
            val random = quotes.indices.random()
            return quotes[random]
        }
        return null
    }
}