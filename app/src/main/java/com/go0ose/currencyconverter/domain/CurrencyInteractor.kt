package com.go0ose.currencyconverter.domain

import com.go0ose.currencyconverter.presentation.model.Currency
import com.go0ose.currencyconverter.presentation.model.Rate
import kotlinx.coroutines.flow.Flow

interface CurrencyInteractor {

    suspend fun getCurrencyResponse(base: String): Currency

    fun getSavedCurrency(): Flow<List<String>>

    suspend fun saveCurrency(currency: Rate)

    suspend fun deleteCurrency(currency: Rate)
}