package com.example.jokeapplication.di

import com.example.jokeapplication.data.repository.MainRepoSource
import com.example.jokeapplication.data.repository.MainRepoSourceImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MainRepoSource> {
        MainRepoSourceImpl(remoteDataSource = get(), localDataSource = get())
    }
}