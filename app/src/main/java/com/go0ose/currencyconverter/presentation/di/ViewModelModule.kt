package com.go0ose.currencyconverter.presentation.di

import com.go0ose.currencyconverter.domain.CurrencyInteractor
import com.go0ose.currencyconverter.presentation.mainScreen.MainViewModel
import com.go0ose.currencyconverter.presentation.mainScreen.pages.FavoriteViewModel
import com.go0ose.currencyconverter.presentation.mainScreen.pages.PopularViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    fun provideMainViewModel(): MainViewModel {
        return MainViewModel()
    }

    @Provides
    fun providePopularViewModel(
        currencyInteractor: CurrencyInteractor
    ): PopularViewModel {
        return PopularViewModel(currencyInteractor)
    }

    @Provides
    fun provideFavoriteViewModel(
        currencyInteractor: CurrencyInteractor
    ): FavoriteViewModel {
        return FavoriteViewModel(currencyInteractor)
    }
}