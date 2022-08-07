package com.example.rparcas.ejemplomvvm.model

//Una data class es una clase que contiene solamente atributos que quedemos guardar,

/**
 * Data class de un objeto Quote, representa una cita con su autor
 * @param quote La cita
 * @param author Autor de la cita
 */
data class QuoteModel (val quote:String,val author:String)