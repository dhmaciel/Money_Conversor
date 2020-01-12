package com.dmobile.moneyconversor.repository

import com.dmobile.moneyconversor.model.Conversion
import com.dmobile.moneyconversor.service.ExchangeRateService

class ConverterRespository(private val exchangeRateService: ExchangeRateService) {

    suspend fun fetchCurrentQuotation(conversion: Conversion) =
        exchangeRateService.listLatestRates(conversion.currency, conversion.currencyWish)
}