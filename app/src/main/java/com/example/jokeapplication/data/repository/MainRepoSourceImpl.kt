package com.example.jokeapplication.data.repository

import com.example.jokeapplication.data.local.LocalDataSource
import com.example.jokeapplication.data.remote.RemoteDataSource
import com.example.jokeapplication.model.Joke

class MainRepoSourceImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MainRepoSource {
    override suspend fun getAllOldJokes(): List<Joke> {
        return localDataSource.getAllOldJokes()
    }

    override suspend fun getNewJoke(): String {
        return remoteDataSource.getJoke()
    }
}