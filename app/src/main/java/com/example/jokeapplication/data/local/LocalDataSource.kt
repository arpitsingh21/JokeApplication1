package com.example.jokeapplication.data.local

import com.example.jokeapplication.model.Joke

interface LocalDataSource {
    suspend fun getAllOldJokes(): List<Joke>
}