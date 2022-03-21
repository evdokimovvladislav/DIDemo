package com.example.didemo.di

import com.example.didemo.data.RepositoryImpl
import com.example.didemo.data.network.DogApi
import com.example.didemo.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module(includes = [DataBindModule::class])
class DataModule {

    @Provides
    fun provideDogApi() = Retrofit.Builder()
        .baseUrl(DogApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create<DogApi>()
}

@Module
interface DataBindModule {

    @Binds
    fun bindRepositoryImplToRepository(repositoryImpl: RepositoryImpl): Repository
}