package com.dmobile.moneyconversor.data.repository

import com.dmobile.moneyconversor.data.repository.datasource.ConverterDataSource
import com.dmobile.moneyconversor.domain.repository.ConverterRepository
import com.dmobile.moneyconversor.model.Conversion

class ConverterRepositoryImpl(private val converterDataSource: ConverterDataSource) :
    ConverterRepository {

    override suspend fun fetchCurrentQuotation(conversion: Conversion) =
        converterDataSource.listLatestRates(conversion.currency, conversion.currencyWish)
}