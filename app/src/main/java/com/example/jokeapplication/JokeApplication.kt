package com.example.jokeapplication

import android.app.Application
import com.example.jokeapplication.di.dataSourceModule
import com.example.jokeapplication.di.repositoryModule
import com.example.jokeapplication.di.roomModule
import com.example.jokeapplication.di.viewModelModule
import networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class JokeApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JokeApplication)
            modules(networkModule)
            modules(repositoryModule)
            modules(dataSourceModule)
            modules(roomModule)
            modules(viewModelModule)
        }
    }
}