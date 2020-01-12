package com.dmobile.moneyconversor.model


data class Conversion(
    val currency: String,
    val value: Double,
    val currencyWish: String,
    var convertedValue: Double? = 0.0
)