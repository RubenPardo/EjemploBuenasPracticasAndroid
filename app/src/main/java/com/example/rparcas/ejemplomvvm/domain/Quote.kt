package com.example.rparcas.ejemplomvvm.domain

import com.example.rparcas.ejemplomvvm.data.database.entities.QuoteEntity
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel

/**
 * Data class en la que trabajaran domain y UI
 * para asi desentenderse de como trabaja la API y la DB interna
 */
data class Quote(val quote:String, val author:String)


// ----------------------------------------------
// Explicacion de las funciones de extension
// [https://devexperto.com/funciones-extension-kotlin-android/]
//--------------------------------------------

/**
 * Funcion de extension para Quote Model
 * De esta forma podemos mapear de una forma sencilla
 * de Quote Model a Quote
 */
fun QuoteModel.toDomain() = Quote(quote, author)

/**
 * Funcion de extension para QuoteEntity
 * De esta forma podemos mapear de una forma sencilla
 * de Quote Model a Quote
 */
fun QuoteEntity.toDomain() = Quote(quote, author)