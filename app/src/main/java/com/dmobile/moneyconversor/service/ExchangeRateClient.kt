package com.dmobile.moneyconversor.service

import com.dmobile.moneyconversor.common.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ExchangeRateClient {
    fun getExchangeRateClient() : ExchangeRateService{
        val client = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()

        val moshi = Moshi.Builder()
            .add(RateAdapter())
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(ExchangeRateService::class.java)
    }
}