package com.example.rparcas.ejemplomvvm.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rparcas.ejemplomvvm.domain.GetQuotesUseCase
import com.example.rparcas.ejemplomvvm.domain.GetRandomQuoteUseCase
import com.example.rparcas.ejemplomvvm.domain.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Anotacion para poder "trucar el dispatcher"
@ExperimentalCoroutinesApi
class QuoteViewModelTest{

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase
    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    //arch.core era la que nos permitiría testear los LiveData y para ello hay que crear una regla
    @get:Rule
    var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase,getRandomQuoteUseCase)
        // Al usar corrutinas hay que "trucar" el dispatcher ( encargado de gestionarlas)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }


    @After
    fun onAfter(){
        // Volver a su sitio el dispatcher
        Dispatchers.resetMain()
    }


    @Test
    fun whenViewModelIsCreatedTheFirstTimeGetAllQuotesAndSetTheFirstValue() = runTest {
        // Given
        val quoteList = listOf(Quote("Quote 1","Author1"), Quote("Quote 2", "Author 2"))
        coEvery { getQuotesUseCase() } returns quoteList

        // When
        quoteViewModel.onCreate()

        // Then
        // comprobar el live date
        assert(quoteViewModel.quoteModel.value == quoteList.first())
    }

    @Test
    fun whenRandomQuoteUseCaseReturnAQuotesetOnLiveData() = runTest{
        // Given
        val quote= Quote("Quote 1","Author1")
        coEvery { getRandomQuoteUseCase() } returns quote

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

    @Test
    fun whenRandomQuoteUseCaseReturnANullKeepTheLastValue() = runTest{
        // Given
        val quote= Quote("Quote 1","Author1")
        quoteViewModel.quoteModel.value = quote
        coEvery { getRandomQuoteUseCase() } returns null

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.quoteModel.value == quote)
    }
}