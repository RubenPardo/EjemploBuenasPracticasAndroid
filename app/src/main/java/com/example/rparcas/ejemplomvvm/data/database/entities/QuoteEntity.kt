package com.example.rparcas.ejemplomvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rparcas.ejemplomvvm.domain.Quote


/**
 * Representacion del modelo para la Base de datos
 * se podria poner el mismo data class de quote pero
 * puede llegar a ser un lio. Es mejor opcion separarlo
 * y crear un mapper a nivel de domain y UI
 */
@Entity(tableName = "quote_table")
data class QuoteEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id:Int=0,
    @ColumnInfo(name = "quote") val quote:String,
    @ColumnInfo(name = "author") val author:String)


fun Quote.toDatabase() = QuoteEntity(quote=quote,author=author)