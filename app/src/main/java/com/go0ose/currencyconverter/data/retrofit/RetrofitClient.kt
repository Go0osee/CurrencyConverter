package com.go0ose.currencyconverter.data.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URl = "https://api.apilayer.com/exchangerates_data/"
    const val BASE_API_KEY = "BRF1NnC51Ub710TC1BnEqdXRGmErSsIS"

    private var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun getCurrencyClient() = Retrofit.Builder()
        .baseUrl(BASE_URl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getCurrencyApi(): CurrencyApi = getCurrencyClient().create(CurrencyApi::class.java)
}