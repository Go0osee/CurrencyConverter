package com.go0ose.currencyconverter.presentation.di

import androidx.lifecycle.ViewModel
import com.go0ose.currencyconverter.presentation.mainScreen.pages.FavoriteViewModel
import com.go0ose.currencyconverter.presentation.mainScreen.pages.PopularViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    fun bindPopularViewModel(popularViewModel: PopularViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun bindFavoriteViewModel(favoriteViewModel: FavoriteViewModel): ViewModel
}