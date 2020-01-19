package com.dmobile.moneyconversor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import com.dmobile.moneyconversor.R
import kotlinx.android.synthetic.main.activity_converter.*
import org.koin.android.ext.android.inject

class ConverterActivity : AppCompatActivity() {

    private val viewModel: ConverterViewModel by inject()
    private lateinit var currencyArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        currencyArray = resources.getStringArray(R.array.currency_symbol_arrays)

        addObservers()

        spinner_money_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                val currencyListWithoutItem = viewModel.getCurrencyListWithoutItem(
                        parent?.getItemAtPosition(position).toString(),
                        currencyArray
                )
                addsItemsToWishSpinner(currencyListWithoutItem)
            }
        }

        button_convert.setOnClickListener {
            viewModel.convertCurrency(
                    spinner_money_type.selectedItem.toString(),
                    edit_value.editText?.text.toString(),
                    spinner_money_wish.selectedItem.toString())
        }
    }

    private fun addObservers() {
        viewModel.currentQuotation.observe(this, Observer {
            val aux = ""
        })
    }

    private fun addsItemsToWishSpinner(items: Array<String>) {
        spinner_money_wish.adapter =
                ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, items)
    }
}