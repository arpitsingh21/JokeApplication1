package com.example.jokeapplication.di

import com.example.jokeapplication.ui.adapters.JokesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        JokesViewModel(repository = get())
    }
}