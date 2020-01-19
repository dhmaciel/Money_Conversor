package com.dmobile.moneyconversor.di

import com.dmobile.moneyconversor.ui.ConverterViewModel
import com.dmobile.moneyconversor.ui.LoginViewModel
import org.koin.dsl.module

val converterModule = module {
    factory { ConverterViewModel(get()) }
    factory { LoginViewModel() }
}