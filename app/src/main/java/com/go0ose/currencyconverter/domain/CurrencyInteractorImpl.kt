package com.go0ose.currencyconverter.domain

import com.go0ose.currencyconverter.presentation.model.Currency
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.utils.toCurrency
import com.go0ose.currencyconverter.utils.toCurrencyEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CurrencyInteractorImpl(
    private val currencyRepository: CurrencyRepository
) : CurrencyInteractor {

    override suspend fun getCurrencyResponse(base: String): Currency {
        return currencyRepository.getCurrencyResponse(base).toCurrency()
    }

    override fun getSavedCurrency(): Flow<List<String>> {
        return currencyRepository.getSavedCurrency().map { list ->
            list.map { currencyEntity ->
                currencyEntity.name
            }
        }
    }

    override suspend fun saveCurrency(currency: Rate) {
        currencyRepository.saveCurrency(currency.toCurrencyEntity())
    }

    override suspend fun deleteCurrency(currency: Rate) {
        currencyRepository.deleteCurrency(currency.toCurrencyEntity())
    }
}