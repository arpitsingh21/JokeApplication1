package com.example.jokeapplication.data.repository

import com.example.jokeapplication.model.Joke

interface MainRepoSource {
    suspend fun getAllOldJokes(): List<Joke>
    suspend fun getNewJoke(): String
}