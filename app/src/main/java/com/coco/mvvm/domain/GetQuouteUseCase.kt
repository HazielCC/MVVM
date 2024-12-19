package com.coco.mvvm.domain

import com.coco.mvvm.data.QuoteRepository
import com.coco.mvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuouteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteModel> {
        return quoteRepository.getAllQuotes()
    }
}