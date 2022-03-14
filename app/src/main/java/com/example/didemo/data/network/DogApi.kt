package com.example.didemo.data.network

import com.example.didemo.domain.models.Dog
import retrofit2.http.GET

/**
 * Интерфейс для работы с Retrofit2
 */
interface DogApi {

    /**
     * Скачивание иноформации о собаке из интернета
     *
     * @return экземпляр собаки
     */
    @GET("api/breeds/image/random")
    suspend fun getDogInfo(): Dog

    companion object {
        const val BASE_URL = "https://dog.ceo/"
    }
}