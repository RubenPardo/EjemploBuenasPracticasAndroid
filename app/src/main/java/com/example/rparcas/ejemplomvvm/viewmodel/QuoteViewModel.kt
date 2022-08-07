package com.example.rparcas.ejemplomvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rparcas.ejemplomvvm.model.QuoteModel
import com.example.rparcas.ejemplomvvm.model.QuoteProvider

/**
 * Clase que vincula la vista con el modelo mediante los
 * mutable live data con el patron observer
 *
 * La vista tendra callbacks que llamen a metodos del view model
 * Y el view model actualiza las variables de live data las cuales
 * desde la vista se pueden suscribir para que de esta forma
 * se les avise cuando algo cambie y se repinte
 */
class QuoteViewModel : ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }

}