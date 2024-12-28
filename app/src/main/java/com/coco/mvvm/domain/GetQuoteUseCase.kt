package com.coco.mvvm.domain

import com.coco.mvvm.data.QuoteRepository
import com.coco.mvvm.data.database.entities.toDataBase
import com.coco.mvvm.domain.model.Quote
import javax.inject.Inject

// Esta clase define el caso de uso para obtener citas (quotes).
class GetQuoteUseCase @Inject constructor(
    // Inyección de dependencias: El repositorio de citas se inyecta automáticamente.
    private val quoteRepository: QuoteRepository
) {
    // Función suspendida que se invoca utilizando el operador `invoke`.
    // Esto permite que la función sea llamada como un operador, es decir, sin especificar su nombre explícitamente.
    suspend operator fun invoke(): List<Quote> {
        // Obtiene todas las citas desde la API.
        val quotes = quoteRepository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            // Si la lista de citas no está vacía:
            // Borra todas las citas de la base de datos local.
            quoteRepository.deleteAllQuotesFromDb()
            // Guarda las nuevas citas en la base de datos local después de convertirlas al formato de base de datos.
            quoteRepository.saveQuotesToDb(quotes.map { it.toDataBase() })
            // Retorna la lista de citas obtenidas desde la API.
            quotes
        } else {
            // Si la lista de citas está vacía, obtiene todas las citas desde la base de datos local.
            quoteRepository.getAllQuotesFromDb()
        }
    }
}
