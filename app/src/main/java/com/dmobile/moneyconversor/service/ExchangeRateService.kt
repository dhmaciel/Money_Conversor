package com.dmobile.moneyconversor.service

import com.dmobile.moneyconversor.model.Rate
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRateService {

    // https://api.exchangeratesapi.io/latest?symbols=BRL&&base=USD
    @GET("latest")
    suspend fun listLatestRates(@Query("symbols") symbol: String, @Query("base") base: String): Rate
}