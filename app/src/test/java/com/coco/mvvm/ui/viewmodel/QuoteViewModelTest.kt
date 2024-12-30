package com.coco.mvvm.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.coco.mvvm.domain.GetQuoteUseCase
import com.coco.mvvm.domain.GetRandomQuoteUseCase
import com.coco.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @RelaxedMockK
    private lateinit var getQuoteUseCase: GetQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun before() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        quoteViewModel = QuoteViewModel(
            getQuoteUseCase = getQuoteUseCase,
            getRandomQuoteUseCase = getRandomQuoteUseCase
        )
    }

    @After
    fun after() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when ViewModel is created at first time, get all quotes and set the first value`() =
        runTest {
            val quoteList = listOf(
                Quote(1, "mundo", "haziel")
            )

            coEvery { getQuoteUseCase() } returns quoteList

            // when
            quoteViewModel.onCreate()

            // Then
            assert(true)
            assert(quoteViewModel.quoteModel.value == quoteList.first())
        }

    @Test
    fun `When GetRandomQuoteUseCase return a Quote Valid, Set on the live data`() =
        runTest {
            // given
            val quote = Quote(1, "mundo", "haziel")

            coEvery { getRandomQuoteUseCase() } returns quote

            // when
            quoteViewModel.getQuoteProvider()

            // Then
            println("Actual value: ${quoteViewModel.quoteModel.value}")
            assert(true)
            assert(quoteViewModel.quoteModel.value == quote)
        }

    @Test
    fun `if GetRandomQuoteUseCase return a null keep the last value`() =
        runTest {
            // given
            val quote = Quote(1, "mundo", "haziel")
            quoteViewModel.quoteModel.value = quote
            coEvery { getRandomQuoteUseCase() } returns null

            // when
            quoteViewModel.getQuoteProvider()

            // Then
            println("Actual value: ${quoteViewModel.quoteModel.value}")
            assert(true)
            assert(quoteViewModel.quoteModel.value == quote)

        }
}