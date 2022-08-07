package com.example.rparcas.ejemplomvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.rparcas.ejemplomvvm.databinding.ActivityMainBinding
import com.example.rparcas.ejemplomvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    // by viewModels es la librearia que conecta el viewmodel con la vista y controla
    //  el flujo de datos y el ciclo de vida
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // nos subscribimos al live data
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->

            // cuando el live data tenga un cambio se llamara a esta funcion
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author

        })

        // ponemos el listener de la vista
        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}