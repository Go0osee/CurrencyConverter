package com.go0ose.currencyconverter.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.String

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey
    var name: String,
)