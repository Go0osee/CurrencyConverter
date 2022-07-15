package com.go0ose.currencyconverter.data.di

import android.content.Context
import androidx.room.Room
import com.go0ose.currencyconverter.data.storage.CurrencyDao
import com.go0ose.currencyconverter.data.storage.CurrencyDataBase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {
    @Provides
    fun provideCurrencyDataBase(
        context: Context
    ): CurrencyDataBase {
        return Room.databaseBuilder(
            context,
            CurrencyDataBase::class.java,
            "currency"
        ).build()
    }

    @Provides
    fun provideCurrencyDao(
        currencyDataBase: CurrencyDataBase
    ): CurrencyDao {
        return currencyDataBase.getCurrencyDao()
    }
}