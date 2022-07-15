package com.go0ose.currencyconverter.utils

import com.go0ose.currencyconverter.data.retrofit.CurrencyResponse
import com.go0ose.currencyconverter.data.storage.entity.CurrencyEntity
import com.go0ose.currencyconverter.presentation.model.Currency
import com.go0ose.currencyconverter.presentation.model.Rate
import com.go0ose.currencyconverter.presentation.model.Sort

fun List<Rate>.sorting(sort: Sort): List<Rate> {
    return when (sort) {
        is Sort.AlphabetAscending -> this.sortedBy { it.name }
        is Sort.AlphabetDescending -> this.sortedBy { it.name }.reversed()
        is Sort.ValueAscending -> this.sortedBy { it.value.toDouble() }
        is Sort.ValueDescending -> this.sortedBy { it.value.toDouble() }.reversed()
    }
}

fun CurrencyResponse.toCurrency() = Currency(
    success = success,
    base = base,
    date = date,
    timestamp = timestamp,
    rates = listOf(
        Rate("USD", rates.USD),
        Rate("EUR", rates.EUR),
        Rate("BYN", rates.BYN),
        Rate("UAH", rates.UAH),
        Rate("RUB", rates.RUB),
        Rate("JPY", rates.JPY),
        Rate("GBP", rates.GBP),
        Rate("AUD", rates.AUD),
        Rate("CAD", rates.CAD),
        Rate("CHF", rates.CHF),
        Rate("CNY", rates.CNY)
    )
)

fun Rate.toCurrencyEntity() = CurrencyEntity(name)
