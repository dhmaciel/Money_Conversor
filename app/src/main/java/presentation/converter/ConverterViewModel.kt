package presentation.converter

import androidx.lifecycle.*
import com.dmobile.moneyconversor.domain.repository.ConverterRepository
import com.dmobile.moneyconversor.domain.usercase.ConverterUserCase
import com.dmobile.moneyconversor.model.Conversion
import com.dmobile.moneyconversor.model.Quotation
import com.dmobile.moneyconversor.model.Rate
import kotlinx.coroutines.*

class ConverterViewModel(private val converterUserCase: ConverterUserCase) : ViewModel() {

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
           convertValue(converterUserCase.get(conversion), value, currency)
        }
    }

    // This logic should be taken to the UserCase class
    private fun convertValue(rate: Rate, value: String, currency: String) {
        val convertedValue = value.toDouble() * rate.quotation
        _currentQuotation.postValue(Quotation(currency, rate.base, rate.quotation, convertedValue, rate.date))
    }
}