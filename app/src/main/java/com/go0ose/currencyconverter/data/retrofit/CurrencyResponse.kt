package com.go0ose.currencyconverter.data.retrofit

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("success")
    val success: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: ListRate
)

data class ListRate(
    @SerializedName("USD")
    val USD: String,
    @SerializedName("EUR")
    val EUR: String,
    @SerializedName("BYN")
    val BYN: String,
    @SerializedName("UAH")
    val UAH: String,
    @SerializedName("RUB")
    val RUB: String,
    @SerializedName("JPY")
    val JPY: String,
    @SerializedName("GBP")
    val GBP: String,
    @SerializedName("AUD")
    val AUD: String,
    @SerializedName("CAD")
    val CAD: String,
    @SerializedName("CHF")
    val CHF: String,
    @SerializedName("CNY")
    val CNY: String
)

