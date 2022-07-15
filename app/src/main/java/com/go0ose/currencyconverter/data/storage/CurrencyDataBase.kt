package com.go0ose.currencyconverter.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.go0ose.currencyconverter.data.storage.entity.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = CurrencyDataBase.VERSION
)
abstract class CurrencyDataBase : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun getCurrencyDao(): CurrencyDao
}
