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
```
