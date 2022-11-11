package com.example.jokeapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.jokeapplication.model.Joke

interface MainRepoSource {
    fun getAllOldJokes(): LiveData<List<Joke>>
    suspend fun getNewJoke()
}