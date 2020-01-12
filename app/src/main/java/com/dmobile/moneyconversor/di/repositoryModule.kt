package com.dmobile.moneyconversor.di

import com.dmobile.moneyconversor.repository.ConverterRespository
import org.koin.dsl.module

val repositoryModule = module {
    single { ConverterRespository(get()) }
}