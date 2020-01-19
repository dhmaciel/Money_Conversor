package com.dmobile.moneyconversor.model


data class Rate(
    val base: String,
    val date: String,
    val quotation: Double
)