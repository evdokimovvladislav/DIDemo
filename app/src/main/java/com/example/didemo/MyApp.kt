package com.example.didemo

import android.app.Application
import com.example.didemo.di.data.dataModule
import com.example.didemo.di.domain.domainModule
import com.example.didemo.di.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}