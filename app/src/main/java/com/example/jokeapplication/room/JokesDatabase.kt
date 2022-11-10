package com.example.jokeapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jokeapplication.model.Joke

@Database(entities = [Joke::class], version = 1, exportSchema = false)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun getJokesDao(): JokesDao
}