package com.dmobile.moneyconversor.di

import org.koin.dsl.module

val repositoryModule = module {
    single { ConverterRespository(get()) }
}