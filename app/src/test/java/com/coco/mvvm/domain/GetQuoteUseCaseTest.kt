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

    // Inicializa QuoteRepository usando MockK para simulaciones relajadas
    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    // Caso de uso que se probará
    private lateinit var getQuoteUseCase: GetQuoteUseCase

    @Before
    fun onBefore() {
        // Configuración de MockK y del caso de uso antes de cada prueba
        MockKAnnotations.init(this)
        getQuoteUseCase = GetQuoteUseCase(quoteRepository)
    }

    @Test
    fun `cuando la api no devuelve nada, obtener el valor de la base de datos`() = runBlocking {
        // Dado que la API devuelve una lista vacía
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        // Cuando se invoca el caso de uso
        getQuoteUseCase.invoke()

        // Entonces verifica que se llama a getAllQuotesFromDb() exactamente una vez,
        // y que no se llaman a deleteAllQuotesFromDb() ni a saveQuotesToDb()
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDb() }
        coVerify(exactly = 0) { quoteRepository.deleteAllQuotesFromDb() }
        coVerify(exactly = 0) { quoteRepository.saveQuotesToDb(emptyList()) }
    }

    @Test
    fun `cuando la api devuelve algo, limpiar la DB y guardar todas las nuevas citas en la DB`() =
        runBlocking {
            // Dado que la API devuelve una lista de citas
            val quotes = listOf(Quote(1, "mundo", "haziel"))
            coEvery { quoteRepository.getAllQuotesFromApi() } returns quotes

            // Cuando se invoca el caso de uso
            val response = getQuoteUseCase.invoke()

            // Entonces verifica que la respuesta sea igual a las citas,
            // que se llama a deleteAllQuotesFromDb() y a saveQuotesToDb() con las citas transformadas,
            // y que no se llama a getAllQuotesFromDb()
            assert(response == quotes)
            coVerify(exactly = 1) { quoteRepository.deleteAllQuotesFromDb() }
            coVerify(exactly = 1) { quoteRepository.saveQuotesToDb(quotes.map { it.toDataBase() }) }
            coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDb() }
        }
}
