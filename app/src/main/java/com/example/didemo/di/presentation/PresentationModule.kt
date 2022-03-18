package com.example.didemo.di.presentation

import com.example.didemo.presentation.DogImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<DogImageViewModel> {
        DogImageViewModel(getDogUseCase = get())
    }
}