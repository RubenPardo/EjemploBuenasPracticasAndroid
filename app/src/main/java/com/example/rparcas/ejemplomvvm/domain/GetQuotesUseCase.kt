package com.example.rparcas.ejemplomvvm.domain

import com.example.rparcas.ejemplomvvm.data.QuoteRepository
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository:QuoteRepository)/*Preparar para poder inyectarse*/{

    //private val repository = QuoteRepository() Quitar todas las instancias de objetos pasarlo a el constructor del inject


    /*
     * El operador invoke() proporciona una  función de operador.
     * Especificar un operador de invocación en una clase permite
     * llamarlo en cualquier instancia de la clase sin un nombre de método.
     *
     * class Greeter(val greeting: String) {
     *   operator fun invoke(name: String) {
     *   println("$greeting $name")
     *   }
     *   }
     *
     *   fun main(args: Array<String>) {
     *      val greeter = Greeter(greeting = "Welcome")
     *      greeter(name = "Kotlin")
     *      //this calls the invoke function which takes String as a parameter
     *   }
     *
     *
     */
    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuotes()
    }

}