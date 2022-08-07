package com.example.rparcas.ejemplomvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// NO SE USA, SE OBTIENE MEDIANTE EL NETWORK MODULE
// Y CON EL PROVEEDOR DE DAGGER HILT
object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                // endpoint a la API
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}