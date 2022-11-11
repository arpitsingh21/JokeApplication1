package com.example.jokeapplication.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jokeapplication.model.Joke

interface JokesDao {
    @Query("SELECT * FROM joke")
    fun getAllJokes(): List<Joke>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJoke(vararg joke: Joke)
}