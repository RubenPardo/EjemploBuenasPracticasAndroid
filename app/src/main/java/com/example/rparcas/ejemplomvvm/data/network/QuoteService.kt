package com.example.rparcas.ejemplomvvm.data.network

import com.example.rparcas.ejemplomvvm.core.RetrofitHelper
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Implementacion de las peticiones de quote con retrofit
 */
class QuoteService {

    private val retrofit = RetrofitHelper.getRetrogit()

    suspend fun getQuotes():List<QuoteModel>{

        // Esto se ejecutaria en el hilo principal de la aplicacion
        /*val response: Response<List<QuoteModel>> =
            retrofit.create(QuoteApiClient::class.java).getAllQuotes()

        // si es null devuelve lista vacia
        return response.body() ?: emptyList()*/

        // Forma correcta de hacerlo, lanzarlo en un hilo separado
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> =
                retrofit.create(QuoteApiClient::class.java).getAllQuotes()

            // si es null devuelve lista vacia
            response.body() ?: emptyList()
        }

    }
}