package com.example.rparcas.ejemplomvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

//Clase que simula la obtencion de datos


/**
 * DEBE SER SINGLETON PORQUE SE INYECTA EN DOS PARTES DISTINTAS
 * GetRandomQuoteUseCase Y EN QuoteRepository POR TANTO
 * CUANDO GetQuotesUseCase LLAMA A getAllQuotes DEL REPOSITORIO
 * Y LAS GUARDA EN la variable de quotes de QuoteRepository NO VA A SER LA MISMA
 * INSTANCIA QUE TIENE GetRandomQuoteUseCase
 */
@Singleton
class QuoteProvider @Inject constructor(){
    // COMPANION OBJECT ES SIMILAR A UNA CLASE ESTATICA
    //companion object{ Si lo inyectamos ya no nos haria falta

       var quotes:List<QuoteModel> = emptyList()
    //}
}