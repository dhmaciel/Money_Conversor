package com.dmobile.moneyconversor.ui

import androidx.lifecycle.*
import com.dmobile.moneyconversor.model.Conversion
import com.dmobile.moneyconversor.model.Quotation
import com.dmobile.moneyconversor.model.Rate
import com.dmobile.moneyconversor.repository.ConverterRespository
import kotlinx.coroutines.*

class ConverterViewModel(private val converterRespository: ConverterRespository) : ViewModel() {

    private var _currentQuotation = MutableLiveData<Quotation>()
    val currentQuotation: LiveData<Quotation>
        get() = _currentQuotation

    fun getCurrencyListWithoutItem(item: String, currencyList: Array<String>): Array<String> {
        val listWithoutItem = currencyList.toList().filterNot { it == item }
        return listWithoutItem.toTypedArray()
    }

    fun convertCurrency(currency: String, value: String, currencyWish: String) {
        val conversion = Conversion(currency, value, currencyWish)
        viewModelScope.launch(context = viewModelScope.coroutineContext + Dispatchers.IO) {
           convertValue(converterRespository.fetchCurrentQuotation(conversion), value, currency)
        }
    }

    private fun convertValue(rate: Rate, value: String, currency: String) {
        val convertedValue = value.toDouble() * rate.quotation
        _currentQuotation.postValue(Quotation(currency, rate.base, rate.quotation, convertedValue, rate.date))
    }
}