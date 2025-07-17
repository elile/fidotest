package com.example.fidotest

import android.app.Application
import com.example.fidotest.di.databaseModule
import com.example.fidotest.di.networkModule
import com.example.fidotest.di.repositoryModule
import com.example.fidotest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(networkModule, databaseModule, repositoryModule, viewModelModule)
            )
        }
    }
}