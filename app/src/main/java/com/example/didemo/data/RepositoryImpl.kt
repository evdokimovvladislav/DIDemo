package com.example.didemo.data

import com.example.didemo.data.network.DogApi
import com.example.didemo.domain.repository.Repository
import javax.inject.Inject

/**
 * Реализоция репозитория для работы с сетью
 *
 * @property dogeApi
 */
class RepositoryImpl @Inject constructor(private val dogeApi: DogApi) : Repository {

    override suspend fun getDog() = dogeApi.getDogInfo()
}