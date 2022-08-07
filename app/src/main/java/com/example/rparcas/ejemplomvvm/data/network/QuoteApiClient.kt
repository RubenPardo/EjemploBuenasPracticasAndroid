package com.example.rparcas.ejemplomvvm.data.network

import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interfaz de las peticiones del modelo QUOTE
 */
interface QuoteApiClient {

    // partiendo de la base url (definida en /core/RetrofitHelper)
    // apuntamos a la url que queremos
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}