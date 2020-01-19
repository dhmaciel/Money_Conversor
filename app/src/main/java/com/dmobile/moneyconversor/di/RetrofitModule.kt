package com.dmobile.moneyconversor.di

import com.dmobile.moneyconversor.service.ExchangeRateClient
import org.koin.dsl.module

val retrofitModule = module {
    single { ExchangeRateClient() }
    factory { ExchangeRateClient().getExchangeRateClient() }
}