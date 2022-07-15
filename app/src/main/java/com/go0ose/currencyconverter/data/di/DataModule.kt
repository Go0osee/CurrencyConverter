package com.go0ose.currencyconverter.data.di

import com.go0ose.currencyconverter.data.CurrencyRepositoryImpl
import com.go0ose.currencyconverter.data.retrofit.CurrencyApi
import com.go0ose.currencyconverter.data.retrofit.RetrofitClient
import com.go0ose.currencyconverter.data.storage.CurrencyDao
import com.go0ose.currencyconverter.domain.CurrencyRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCurrencyApi(): CurrencyApi {
        return RetrofitClient.getCurrencyApi()
    }

    @Provides
    fun provideDataBaseRepository(
        currencyDao: CurrencyDao,
        currencyApi: CurrencyApi
    ): CurrencyRepository {
        return CurrencyRepositoryImpl(currencyApi, currencyDao)
    }
}
