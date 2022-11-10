package com.example.jokeapplication.room

import androidx.room.Query
import com.example.jokeapplication.model.Joke

interface JokesDao {
    @Query("SELECT * FROM joke")
    fun getAllJokes(): List<Joke>
}