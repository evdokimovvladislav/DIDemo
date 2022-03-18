package com.example.didemo.di.domain

import com.example.didemo.domain.usecases.GetDogUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetDogUseCase> {
        GetDogUseCase(repository = get())
    }
}