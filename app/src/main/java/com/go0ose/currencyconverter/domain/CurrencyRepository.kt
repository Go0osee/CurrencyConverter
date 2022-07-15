package com.go0ose.currencyconverter.domain

import com.go0ose.currencyconverter.data.retrofit.CurrencyResponse
import com.go0ose.currencyconverter.data.storage.entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun getCurrencyResponse(base: String): CurrencyResponse

    fun getSavedCurrency(): Flow<List<CurrencyEntity>>

    suspend fun saveCurrency(currencyEntity: CurrencyEntity)

    suspend fun deleteCurrency(currencyEntity: CurrencyEntity)

}