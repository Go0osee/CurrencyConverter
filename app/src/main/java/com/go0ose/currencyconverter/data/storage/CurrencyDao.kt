package com.go0ose.currencyconverter.data.storage

import androidx.room.*
import com.go0ose.currencyconverter.data.storage.entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency")
    fun getAllCurrency(): Flow<List<CurrencyEntity>>

    @Insert
    suspend fun saveCurrency(currency: CurrencyEntity)

    @Delete
    suspend fun deleteCurrency(currency: CurrencyEntity)

}
