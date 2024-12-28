package com.coco.mvvm.domain

import com.coco.mvvm.data.QuoteRepository
import com.coco.mvvm.data.database.entities.toDataBase
import com.coco.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuoteUseCaseTest {

    // Init Quote Repository
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    // Use case
    private lateinit var getQuoteUseCase: GetQuoteUseCase

    @Before
    fun onBefore() {
        // Setup
        MockKAnnotations.init(this)
        getQuoteUseCase = GetQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when the api does return anything then get the value from database`() = runBlocking {
        // Given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        // When
        getQuoteUseCase.invoke()

        // Then
        // Verify that the method getAllQuotesFromApi() is called
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDb() }
        coVerify(exactly = 0) { quoteRepository.deleteAllQuotesFromDb() }
        coVerify(exactly = 0) { quoteRepository.saveQuotesToDb(emptyList()) }
    }

    @Test
    fun `when the api return something then clear the DB and save all new Quotes on the DB `() =
        runBlocking {
            // given
            val quotes = listOf(Quote(1, "mundo", "haziel"))
            coEvery { quoteRepository.getAllQuotesFromApi() } returns quotes

            // when
            val response = getQuoteUseCase.invoke()

            // then
            assert(response == quotes)
            coVerify(exactly = 1) { quoteRepository.deleteAllQuotesFromDb() }
            coVerify(exactly = 1) { quoteRepository.saveQuotesToDb(quotes.map { it.toDataBase() }) }
            coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDb() }

        }
}
