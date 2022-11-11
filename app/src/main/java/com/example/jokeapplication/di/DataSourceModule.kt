package com.example.jokeapplication.di

import com.example.jokeapplication.data.local.LocalDataSource
import com.example.jokeapplication.data.local.LocalDataSourceImpl
import com.example.jokeapplication.data.remote.RemoteDataSource
import com.example.jokeapplication.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> {
        RemoteDataSourceImpl(jokesService = get())
    }
    single<LocalDataSource> {
        LocalDataSourceImpl(dao = get())
    }

}