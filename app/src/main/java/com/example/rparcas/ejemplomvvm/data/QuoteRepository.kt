package com.example.rparcas.ejemplomvvm.data

import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import com.example.rparcas.ejemplomvvm.data.model.QuoteProvider
import com.example.rparcas.ejemplomvvm.data.network.QuoteService

/**
 * Repositorio para el modelo de quotes
 * De esta forma si cambiamos de metodo de acceso a la api
 * los cambios son minimos, es decir esta clase apunta a que
 * forma de acceso a los datos apunta
 *
 */
class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()

        // lo guardamos en memoria
        QuoteProvider.quotes = response

        return response
    }

}