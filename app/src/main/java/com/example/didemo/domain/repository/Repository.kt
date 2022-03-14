package com.example.didemo.domain.repository

import com.example.didemo.domain.models.Dog

interface Repository {

    fun getDog(): Dog
}