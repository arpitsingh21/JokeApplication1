package com.example.jokeapplication.data.local

import androidx.lifecycle.LiveData
import com.example.jokeapplication.model.Joke
import com.example.jokeapplication.room.JokesDao

class LocalDataSourceImpl(private val dao: JokesDao) : LocalDataSource {
    override fun getAllOldJokes(): LiveData<List<Joke>> {
        return dao.getAllJokes()
    }

    override suspend fun insertJoke(joke: Joke) {
        return dao.insertJoke(joke)
    }
}