package com.example.rparcas.ejemplomvvm.domain

import com.example.rparcas.ejemplomvvm.data.QuoteRepository
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import com.example.rparcas.ejemplomvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider)/*Preparar para poder inyectarse*/{

    //private val repository = QuoteRepository() Quitar todas las instancias de objetos pasarlo a el constructor del inject

    // no es una corrutina porque esta guardado en memoria
    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (0..quotes.size-1).random()
            return quotes[randomNumber]
        }

        return null
    }

}