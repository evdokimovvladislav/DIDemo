package com.example.didemo

import android.app.Application
import com.example.didemo.di.AppComponent
import com.example.didemo.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appContext(context = this)
            .build()
    }
}