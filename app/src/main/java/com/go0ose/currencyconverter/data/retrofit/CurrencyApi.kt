package com.go0ose.currencyconverter.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {

    @GET("{endpoint}")
    suspend fun getPopularCurrencyResponse(
        @Path("endpoint") endpoint: String = "latest",
        @Query("apikey") apiKey: String = RetrofitClient.BASE_API_KEY,
        @Query("base") base: String,
        @Query("symbols") symbols: String = "USD,EUR,BYN,UAH,RUB,JPY,GBP,AUD,CAD,CHF,CNY"
    ): CurrencyResponse
}