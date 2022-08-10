package com.example.rparcas.ejemplomvvm.domain

import com.example.rparcas.ejemplomvvm.data.QuoteRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

//
// Para que se testee una clase el archivo de test tiene que estar
// con la misma estructura de carpetas bajo la de tests que en la de java
// es decir, java/carpeta1/carpeta2/ClaseATestear.java test/carpeta1/carpeta2/TestClaseATestear.java
// Para hacerlo mas rapido, vamos a la clase a testear pinchamos en el nombre
// y luego en el menu naviagte -> test, al no haber fichero nos dira de crear el
// archivo
class GetQuotesUseCaseTest {

    // queremos mockear el repositorio que es donde pide y recibe datos
    // nuestro caso de uso
    @RelaxedMockK//
    //@MockK La diferencia entre mock y relaxed mock es que mock necesita que definamos todas
    // las respuestas si no fallara el test, relxed mock por otra parte si no esta definida
    // se la inventa
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase// la clase a testear

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    // el run blocking es para tratar con las corrutinas
    @Test
    fun whenTheApiDoesntReturnAnythingThenGetValuesFromDatabase() = runBlocking {
        // La estructura de un test es:
        // Given When Then, dada una condicon//mock, cuando se llama a una funcion,
        // entonces comprueba

        // Given
        // cada vez que el caso de uso llame a get all quotes devolvemos empty
        // el co hace falta por que hay corrutinas, sino solo Every
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        // When
        getQuotesUseCase()

        // Then
        // verifica (corrutina) que se ha llamado a la funcion que queremos una vez
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }
    }


    @Test
    fun whenTheApiReturnsSomethingThenGetValuesFromApi() = runBlocking {

        // Given
        val myList = listOf<Quote>(Quote("Quote 1","autor 1"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList

        // When
        val response = getQuotesUseCase()

        // Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) } // Ponemos any porque requiere de un parametro pero nos da igual
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDatabase() }
        assert(myList == response)

    }

}