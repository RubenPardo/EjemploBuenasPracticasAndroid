# EjemploMVVM

Aplicación de ejemplo para mostrar el uso de la arquitectura MVVM y Clean

## Dependencias y configuración

1. Activar el view binding

En el gradle del modulo app añadir
```
buildFeatures{
    viewBinding = true
}
```

2. Añadir dependencias

```
// Fragment 
implementation "androidx.fragment:fragment-ktx:1.3.2"

// Activity
implementation "androidx.activity:activity-ktx:1.2.2"

// ViewModel
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"

// LiveData  
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"

// Retrofit
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:converter-gson:2.9.0"
//Corrutinas
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6'

```

## Estructura del proyecto

### Core
Directorio donde estan las clases ajenas del poryecto, por ejemplo el RetrofitHelper

### Data
Directorio del modelo de la aplicacion junto a los repostiroios y accesos a la api

### Domain
Logica de negocio de la aplicación, es decir, casos de uso

### UI
View y view model de la aplicación

