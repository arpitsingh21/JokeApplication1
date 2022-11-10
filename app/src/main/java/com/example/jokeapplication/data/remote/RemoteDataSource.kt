package com.example.jokeapplication.data.remote

interface RemoteDataSource {
    suspend fun getJoke(
    ): String
}