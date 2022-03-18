package com.example.didemo.di

import android.content.Context
import com.example.didemo.presentation.DogImageFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class])
@Singleton
interface AppComponent {

    fun inject(fragment: DogImageFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appContext(context: Context): Builder

        fun build(): AppComponent
    }
}