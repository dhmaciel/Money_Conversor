package com.dmobile.moneyconversor.model


data class Conversion(
    val currency: String,
    val value: String,
    val currencyWish: String,
    var convertedValue: String? = "0.0"
)