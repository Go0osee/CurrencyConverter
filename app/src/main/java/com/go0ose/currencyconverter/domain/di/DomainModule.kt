package com.go0ose.currencyconverter.domain.di

import com.go0ose.currencyconverter.domain.CurrencyInteractor
import com.go0ose.currencyconverter.domain.CurrencyInteractorImpl
import com.go0ose.currencyconverter.domain.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DomainModule {

    @Binds
    fun bindCurrencyInteractor(currencyInteractorImpl :CurrencyInteractorImpl): CurrencyInteractor
}