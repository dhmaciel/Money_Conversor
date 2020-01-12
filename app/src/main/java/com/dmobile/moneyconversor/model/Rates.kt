package com.dmobile.moneyconversor.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rates(
    @Json(name = "BRL")
    val bRL: Double
)