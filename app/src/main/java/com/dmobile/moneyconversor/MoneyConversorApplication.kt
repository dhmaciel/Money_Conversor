package com.dmobile.moneyconversor

import android.app.Application
import com.dmobile.moneyconversor.di.converterModule
import com.dmobile.moneyconversor.di.repositoryModule
import com.dmobile.moneyconversor.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoneyConversorApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MoneyConversorApplication)
            modules(listOf(converterModule, retrofitModule, repositoryModule))
        }
    }
}