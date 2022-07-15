package com.go0ose.currencyconverter.domain.di

import com.go0ose.currencyconverter.domain.CurrencyInteractor
import com.go0ose.currencyconverter.domain.CurrencyInteractorImpl
import com.go0ose.currencyconverter.domain.CurrencyRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCurrencyInteractor(
        currencyRepository: CurrencyRepository
    ): CurrencyInteractor {
        return CurrencyInteractorImpl(currencyRepository)
    }
}