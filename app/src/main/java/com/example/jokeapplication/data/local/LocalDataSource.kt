package com.example.jokeapplication.data.local

import androidx.lifecycle.LiveData
import com.example.jokeapplication.model.Joke

interface LocalDataSource {
    fun getAllOldJokes(): LiveData<List<Joke>>
    suspend fun insertJoke(joke: Joke)
}