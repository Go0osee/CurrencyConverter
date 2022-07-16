package com.go0ose.currencyconverter.data.di

import com.go0ose.currencyconverter.data.retrofit.CurrencyApi
import com.go0ose.currencyconverter.data.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides

@Module
class RetrofitModule {

    @Provides
    fun provideCurrencyApi(): CurrencyApi {
        return RetrofitClient.getCurrencyApi()
    }
}
