package com.dmobile.moneyconversor.service

import com.dmobile.moneyconversor.model.Rate
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import java.io.IOException

class RateAdapter {
    @FromJson
    fun fromJson(jsonReader: JsonReader): Rate? {
        jsonReader.run {
            try {
                beginObject()
                if (hasNext()) {
                    skipName()
                    val map = readJsonValue() as Map<*, *>
                    val quotation = map[map.keys.first()] as Double

                    skipName()
                    val base = nextString()

                    skipName()
                    val date = nextString()

                    endObject()
                    return Rate(base, date, quotation)
                }

            } catch (exception: IOException) {
                return null
            }
        }
        return null
    }
}