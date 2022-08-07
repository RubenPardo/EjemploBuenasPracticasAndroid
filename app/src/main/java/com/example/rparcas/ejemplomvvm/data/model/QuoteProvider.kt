package com.example.rparcas.ejemplomvvm.data.model
//Clase que simula la obtencion de datos

class QuoteProvider {
    // COMPANION OBJECT ES SIMILAR A UNA CLASE ESTATICA
    companion object{

       var quotes:List<QuoteModel> = emptyList()
    }
}