package com.example.jokeapplication.data.local

import com.example.jokeapplication.model.Joke
import com.example.jokeapplication.room.JokesDao

class LocalDataSourceImpl(private val dao: JokesDao) : LocalDataSource {
    override suspend fun getAllOldJokes(): List<Joke> {
        return dao.getAllJokes()
    }

    override suspend fun insertJoke(joke: Joke) {
        return dao.insertJoke(joke)
    }
}