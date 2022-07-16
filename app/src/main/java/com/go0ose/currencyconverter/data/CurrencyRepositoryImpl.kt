package com.go0ose.currencyconverter.data

import com.go0ose.currencyconverter.data.retrofit.CurrencyApi
import com.go0ose.currencyconverter.data.retrofit.CurrencyResponse
import com.go0ose.currencyconverter.data.retrofit.ListRate
import com.go0ose.currencyconverter.data.storage.CurrencyDao
import com.go0ose.currencyconverter.data.storage.entity.CurrencyEntity
import com.go0ose.currencyconverter.domain.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyApi,
    private val currencyDao: CurrencyDao
) : CurrencyRepository {

    override suspend fun getCurrencyResponse(base: String): CurrencyResponse {
        return withContext(Dispatchers.IO) {
            return@withContext currencyApi.getPopularCurrencyResponse(base = base)
        }
    }

    override fun getSavedCurrency(): Flow<List<CurrencyEntity>> {
        return currencyDao.getAllCurrency()
    }

    override suspend fun saveCurrency(cityWeatherEntity: CurrencyEntity) {
        return withContext(Dispatchers.IO) {
            return@withContext currencyDao.saveCurrency(cityWeatherEntity)
        }
    }

    override suspend fun deleteCurrency(cityWeatherEntity: CurrencyEntity) {
        return withContext(Dispatchers.IO) {
            return@withContext currencyDao.deleteCurrency(cityWeatherEntity)
        }
    }
}