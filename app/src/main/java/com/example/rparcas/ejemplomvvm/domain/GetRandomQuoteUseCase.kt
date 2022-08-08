package com.example.rparcas.ejemplomvvm.domain

import com.example.rparcas.ejemplomvvm.data.QuoteRepository
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository)/*Preparar para poder inyectarse*/{

    //private val repository = QuoteRepository() Quitar todas las instancias de objetos pasarlo a el constructor del inject

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }

        return null
    }

}