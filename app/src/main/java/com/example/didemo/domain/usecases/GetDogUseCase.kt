package com.example.didemo.domain.usecases

import com.example.didemo.domain.models.Dog
import com.example.didemo.domain.repository.Repository

class GetDogUseCase(private val repository: Repository) {

    operator fun invoke(): Dog = repository.getDog()
}