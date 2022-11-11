package com.example.jokeapplication.di

import androidx.room.Room
import com.example.jokeapplication.config.Config
import com.example.jokeapplication.room.JokesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val roomModule = module {

    single {
        Room.databaseBuilder(androidApplication(), JokesDatabase::class.java, Config.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<JokesDatabase>().getJokesDao()
    }
}