package com.dmobile.moneyconversor.ui

import androidx.lifecycle.*
import com.dmobile.moneyconversor.model.Conversion
import com.dmobile.moneyconversor.model.Rate
import com.dmobile.moneyconversor.repository.ConverterRespository
import kotlinx.coroutines.*

class ConverterViewModel(private val converterRespository: ConverterRespository) : ViewModel() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    lateinit var currentQuotation: LiveData<Rate>

    fun getCurrencyListWithoutItem(item: String, currencyList: Array<String>): Array<String> {
        val listWithoutItem = currencyList.toList().filterNot { it == item }
        return listWithoutItem.toTypedArray()
    }

    fun convertCurrency(currency: String, value: Double, currencyWish: String) {
        val conversion = Conversion(currency, value, currencyWish)

        currentQuotation = liveData {
            emit(converterRespository.fetchCurrentQuotation(conversion))
        }
    }
}