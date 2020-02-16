package com.dmobile.moneyconversor.domain.usercase

import com.dmobile.moneyconversor.domain.repository.ConverterRepository
import com.dmobile.moneyconversor.model.Conversion

class ConverterUserCase constructor(private val converterRespository: ConverterRepository) {

    // Does here is where put the logic when returns of api?
   suspend fun get(conversion: Conversion) = converterRespository.fetchCurrentQuotation(conversion)
}