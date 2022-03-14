package com.example.didemo.domain.repository

import com.example.didemo.domain.models.Dog

/**
 * Интерфейс репозитория
 */
interface Repository {

    /**
     * Получение экземпляра собаки
     *
     * @return экземпляр собаки
     */
    suspend fun getDog(): Dog
}