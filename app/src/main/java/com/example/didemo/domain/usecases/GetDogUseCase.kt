package com.example.didemo.domain.usecases

import com.example.didemo.domain.models.Dog
import com.example.didemo.domain.repository.Repository

/**
 * Класс use case`a получения собаки
 *
 * @property repository - имплементация репозитория
 */
class GetDogUseCase(private val repository: Repository) {

    suspend operator fun invoke(): Dog = repository.getDog()
}