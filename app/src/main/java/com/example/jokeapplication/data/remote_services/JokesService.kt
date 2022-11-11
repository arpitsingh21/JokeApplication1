package com.example.jokeapplication.data.remote_services

import retrofit2.http.GET

interface JokesService {
    @GET("api")
    suspend fun getJoke(
    ): String
}