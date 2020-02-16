package com.dmobile.moneyconversor.di

import presentation.converter.ConverterViewModel
import presentation.login.LoginViewModel
import org.koin.dsl.module

val converterModule = module {
    factory { ConverterViewModel(get()) }
    factory { LoginViewModel() }
}