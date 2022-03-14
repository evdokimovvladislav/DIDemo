package com.example.didemo

import android.app.Application
import com.example.didemo.data.network.DogApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApp : Application() {

    private lateinit var retrofit: Retrofit
    val dogApi: DogApi by lazy { retrofit.create(DogApi::class.java) }

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
            .baseUrl(DogApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}