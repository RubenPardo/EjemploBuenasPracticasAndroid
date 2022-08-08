package com.example.rparcas.ejemplomvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rparcas.ejemplomvvm.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Query("select * from quote_table")
    suspend fun getAllQuotes():List<QuoteEntity>

    // OnConflict es cuando hay dos id iguales, le puedes decir que hacer cuando
    // suceda eso, en nuestro caso lo replazamos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes:List<QuoteEntity>)

    @Query("DELETE FROM quote_table")
    suspend fun delateAllQuotes()
}