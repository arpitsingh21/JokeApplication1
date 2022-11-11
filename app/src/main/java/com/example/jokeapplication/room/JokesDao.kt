package com.example.jokeapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jokeapplication.model.Joke

@Dao
interface JokesDao {
    @Query("SELECT * FROM joke")
    fun getAllJokes(): LiveData<List<Joke>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertJoke(vararg joke: Joke)
}