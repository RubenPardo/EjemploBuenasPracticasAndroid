package com.example.rparcas.ejemplomvvm.domain

import com.example.rparcas.ejemplomvvm.data.QuoteRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase// la clase a testear

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun whenDatabaseIsEmptyReturnNull() = runBlocking {
        // Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()
        // When
        val response = getRandomQuoteUseCase()
        // Then
        assert(response == null)
    }

    @Test
    fun whenDatabaseIsNotEmptyReturnQuote() = runBlocking {
        // Given
        val myList = listOf<Quote>(Quote("quote 1","author 1"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns myList
        // When
        val response = getRandomQuoteUseCase()
        // Then
        assert(response == myList.first())
    }

}