package com.example.didemo.di.data

import com.example.didemo.data.RepositoryImpl
import com.example.didemo.data.network.DogApi
import com.example.didemo.domain.repository.Repository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<Repository> {
        RepositoryImpl(dogeApi = get())
    }

    single<DogApi> {
        provideGogApi(retrofit = get())
    }

    single<Retrofit> {
        provideRetrofitClient()
    }
}

private fun provideRetrofitClient(): Retrofit = Retrofit.Builder()
    .baseUrl(DogApi.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun provideGogApi(retrofit: Retrofit) = retrofit.create(DogApi::class.java)