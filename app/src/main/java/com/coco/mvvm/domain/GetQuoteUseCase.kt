package com.coco.mvvm.domain

import com.coco.mvvm.data.QuoteRepository
import com.coco.mvvm.data.database.entities.toDataBase
import com.coco.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuouteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = quoteRepository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            quoteRepository.deleteAllQuotesFromDb()
            quoteRepository.saveQuotesToDb(quotes.map { it.toDataBase() })
            quotes
        } else {
            quoteRepository.getAllQuotesFromDb()
        }
    }
}