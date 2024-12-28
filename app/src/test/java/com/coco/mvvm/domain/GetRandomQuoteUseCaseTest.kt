package com.coco.mvvm.domain

import com.coco.mvvm.data.QuoteRepository
import com.coco.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuoteUseCaseTest {
    // Init Quote Repository
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    // Use case
    private lateinit var randomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun before() {
        // Setup
        MockKAnnotations.init(this)
        randomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when the quotes are empty should return null`() = runBlocking {
        // given
        coEvery { quoteRepository.getAllQuotesFromDb() } returns emptyList()

        // when
        val response = randomQuoteUseCase()

        // then
        assert(response == null)
    }

    @Test
    fun `when the quotes are not empty should return a random Quote`() = runBlocking {
        // given
        val quotes = listOf(Quote(1, "mundo", "haziel"))
        coEvery { quoteRepository.getAllQuotesFromDb() } returns quotes

        //when
        val result = randomQuoteUseCase()

        // given
        assert(result == quotes.first())
    }
}