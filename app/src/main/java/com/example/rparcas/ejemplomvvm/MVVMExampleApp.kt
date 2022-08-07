package com.example.rparcas.ejemplomvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Clase Aplication con Hilt (debe añadirse en el manifest)
 * Normalmente habria que crear el on create con sus atributos, etc
 * Con dagger hilt genera el codigo necesario
 *
 *
 */
@HiltAndroidApp
class MVVMExampleApp: Application()