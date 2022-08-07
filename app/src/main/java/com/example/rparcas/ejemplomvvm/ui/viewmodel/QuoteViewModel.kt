package com.example.rparcas.ejemplomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rparcas.ejemplomvvm.data.model.QuoteModel
import com.example.rparcas.ejemplomvvm.data.model.QuoteProvider
import com.example.rparcas.ejemplomvvm.domain.GetQuotesUseCase
import com.example.rparcas.ejemplomvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Clase que vincula la vista con el modelo mediante los
 * mutable live data con el patron observer
 *
 * La vista tendra callbacks que llamen a metodos del view model
 * Y el view model actualiza las variables de live data las cuales
 * desde la vista se pueden suscribir para que de esta forma
 * se les avise cuando algo cambie y se repinte
 */
@HiltViewModel// preparar para que le puedan inyectar objetos
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    // EN VEZ DE PONERLAS DIRECTAMENTE LAS INYECTAMOS PARA PODER REALIZAR MEJOR
    // LOS TESTS Y AHORRAR DEPENDENCIAS DIRECTAS
    /*var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()*/

    fun onCreate() {
        // controlador de corrutinas
        viewModelScope.launch {

            isLoading.postValue(true)

            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }


        }
    }

    fun randomQuote(){
        isLoading.postValue(true)


        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }



}