package com.go0ose.currencyconverter.data.di

import com.go0ose.currencyconverter.data.CurrencyRepositoryImpl
import com.go0ose.currencyconverter.domain.CurrencyRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindCurrencyRepository(currencyRepositoryImpl: CurrencyRepositoryImpl) : CurrencyRepository
}