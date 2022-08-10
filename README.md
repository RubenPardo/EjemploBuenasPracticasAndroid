# Proyecto buenas practicas Android

Aplicación de ejemplo para mostrar el uso de la arquitectura MVVM y Clean

También se hace uso de Retrofit2 y Inyeccion de dependencias con [Dagger Hilt](#explicacion-de-dagger-hilt)

Se hace uso de [ROOM](#explicacion-de-room)

Tests unitarios con mockk de los casos de uso y los view model

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
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0'
testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"// testear corrutinas

// mock
testImplementation 'io.mockk:mockk:1.12.2'
testImplementation "androidx.arch.core:core-testing:2.1.0"// testear live data

```

Para añadir Dagger Hilt para la inyección de dependencias, el apartado buildscript del gradle del proyecto debe quedar:
```
buildscript {
    ext.kotlin_version = "1.6.10"
    ext.hilt_version = '2.35' // añadir---------------------------
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.1.3"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version" // añadir---------------------------
    }
}
```

Añadir en el build gradle del modulo app dos id en el apartado de plugin
```
id 'kotlin-kapt'
id 'dagger.hilt.android.plugin'
```
Y las siguientes dependencias
```
// dagger hilt
implementation "com.google.dagger:hilt-android:$hilt_version"
kapt "com.google.dagger:hilt-android-compiler:$hilt_version"
```

Añadir Room
```
 //Room
    implementation "androidx.room:room-ktx:2.4.0"
    kapt "androidx.room:room-compiler:2.4.0"
```

## Estructura del proyecto

### Core
Directorio donde estan las clases ajenas del poryecto, por ejemplo el RetrofitHelper

### Data
Directorio del modelo de la aplicacion junto a los repostiroios, accesos a la api y a la BD interna con ROOM

### Domain
Logica de negocio de la aplicación, es decir, casos de uso

### UI
View y view model de la aplicación

## Explicacion de dagger hilt
Es un patrón de diseño orientado a objetos, en el que se suministran objetos a una clase en lugar de ser la propia clase la que cree dichos objetos. Esos objetos cumplen contratos que necesitan nuestras clases para poder funcionar (de ahí el concepto de dependencia). Nuestras clases no crean los objetos que necesitan, sino que se los suministra otra clase 'contenedora' que inyectará la implementación deseada a nuestro contrato.

En otras palabras, se trata de un patrón de diseño que se encarga de extraer la responsabilidad de la creación de instancias de un componente para delegarla en otro

[Explicación técnia](https://developer.android.com/training/dependency-injection?hl=es-419)

[Video explicativo](https://www.youtube.com/watch?v=t6ZuzSu2UHI&list=PL8ie04dqq7_OcBYDpvHrcSFVoggLi3cm_&index=36)

## Explicacion de ROOM
ROOM es una libreria ORM (Object Relational Mapping) de base datos que simplifica todo el trabajo con ella

[Explicación técnica](https://devexperto.com/room-la-libreria-de-base-de-datos-de-android/#:~:text=Room%20es%20una%20librería%20de,datos%20lista%20para%20ser%20usada.)

[Video explicativo](https://www.youtube.com/watch?v=lYBb4QedYH8&list=PL8ie04dqq7_OcBYDpvHrcSFVoggLi3cm_&index=43)

