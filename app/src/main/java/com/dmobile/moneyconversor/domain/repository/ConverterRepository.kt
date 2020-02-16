package com.dmobile.moneyconversor.domain.repository

import com.dmobile.moneyconversor.model.Conversion
import com.dmobile.moneyconversor.model.Rate

interface ConverterRepository {

   suspend fun fetchCurrentQuotation(conversion: Conversion): Rate
}