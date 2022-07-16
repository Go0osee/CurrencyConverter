package com.go0ose.currencyconverter.presentation.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.go0ose.currencyconverter.presentation.mainScreen.SharedViewModel
import dagger.Module
import dagger.Provides

@Module
class SharedViewModelModule {

    @Provides
    fun provideSharedViewModel(
        viewModelStoreOwner: ViewModelStoreOwner
    ): SharedViewModel {
        return ViewModelProvider(viewModelStoreOwner)[SharedViewModel::class.java]
    }
}