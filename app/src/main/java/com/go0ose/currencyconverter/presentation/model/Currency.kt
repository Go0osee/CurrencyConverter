package com.go0ose.currencyconverter.presentation.model

data class Currency(
    val success: String,
    val timestamp: String,
    val base: String,
    val date: String,
    val rates: List<Rate>
)

data class Rate(
    val name: String,
    val value: String
)
