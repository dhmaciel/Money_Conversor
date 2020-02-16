package com.dmobile.moneyconversor.model

import java.util.*

data class Quotation(
    val originalCurrency: String,
    val wishCurrency: String,
    val quotation: Double,
    val convertedValue: Double,
    val dateQuotation: String
)