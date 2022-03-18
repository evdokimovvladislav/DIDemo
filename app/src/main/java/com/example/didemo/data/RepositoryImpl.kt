package com.example.didemo.data

import com.example.didemo.data.network.DogApi
import com.example.didemo.domain.repository.Repository

/**
 * Реализоция репозитория для работы с сетью
 *
 * @property dogeApi
 */
class RepositoryImpl(private val dogeApi: DogApi) : Repository {

    override suspend fun getDog() = dogeApi.getDogInfo()
}