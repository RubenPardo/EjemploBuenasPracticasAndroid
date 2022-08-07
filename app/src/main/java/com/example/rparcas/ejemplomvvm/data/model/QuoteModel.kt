package com.example.rparcas.ejemplomvvm.data.model

import com.google.gson.annotations.SerializedName

// Una data class es una clase que contiene solamente atributos que quedemos guardar,
//
// Para que Retrofit sea capaz de hacer la peticion REST y transormarlo al objeto
// directamente la variable del data class debe llamarse igual al atributo json
// si no se quiere llamar igual se puede hacer referencia con
// @SerializedName("nombre del atributo json")
/**
 * Data class de un objeto Quote, representa una cita con su autor
 * @param quote La cita
 * @param author Autor de la cita
 */
data class QuoteModel (
    @SerializedName("quote")val quote:String,
    @SerializedName("author")val author:String)