package com.example.rparcas.ejemplomvvm.data

import com.example.rparcas.ejemplomvvm.data.database.dao.QuoteDao
import com.example.rparcas.ejemplomvvm.data.database.entities.QuoteEntity
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import com.example.rparcas.ejemplomvvm.data.network.QuoteService
import com.example.rparcas.ejemplomvvm.domain.Quote
import com.example.rparcas.ejemplomvvm.domain.toDomain
import javax.inject.Inject

/**
 * Repositorio para el modelo de quotes
 * De esta forma si cambiamos de metodo de acceso a la api
 * los cambios son minimos, es decir esta clase apunta a que
 * forma de acceso a los datos apunta
 *
 */
class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteDao:QuoteDao) {

    //private val api = QuoteService() Quitar todas las instancias de objetos pasarlo a el constructor del inject

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response:List<QuoteModel> = api.getQuotes()
        // mapear la lista de quote model a lista de quote
        return response.map{quoteModel -> quoteModel.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response:List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { quoteEntity -> quoteEntity.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
       quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.delateAllQuotes()
    }


}