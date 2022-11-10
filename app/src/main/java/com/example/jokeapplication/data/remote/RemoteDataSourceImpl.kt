package com.example.jokeapplication.data.remote

import com.example.jokeapplication.data.remote_services.JokesService

class RemoteDataSourceImpl(private val jokesService: JokesService) : RemoteDataSource {
    override suspend fun getJoke(): String {
        return jokesService.getJoke()
    }

}