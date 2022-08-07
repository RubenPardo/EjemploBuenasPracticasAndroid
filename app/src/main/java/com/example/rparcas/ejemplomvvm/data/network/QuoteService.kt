package com.example.rparcas.ejemplomvvm.data.network

import com.example.rparcas.ejemplomvvm.core.RetrofitHelper
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/**
 * Implementacion de las peticiones de quote con retrofit
 */
class QuoteService @Inject constructor(private val api:QuoteApiClient) {

    // En vez de poner aqui el retrofit, injectamos el QuoteApiCliente
    // que en la clase NetworkModule proveemos creando ya retrofit
    //private val retrofit = RetrofitHelper.getRetrofit() // RETROFIT

    suspend fun getQuotes():List<QuoteModel>{

        // Esto se ejecutaria en el hilo principal de la aplicacion
        /*val response: Response<List<QuoteModel>> =
            retrofit.create(QuoteApiClient::class.java).getAllQuotes()

        // si es null devuelve lista vacia
        return response.body() ?: emptyList()*/

        // Forma correcta de hacerlo, lanzarlo en un hilo separado
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = api.getAllQuotes()

            // si es null devuelve lista vacia
            response.body() ?: emptyList()
        }

    }
}