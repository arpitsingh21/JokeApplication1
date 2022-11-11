package com.example.jokeapplication.ui.adapters


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokeapplication.data.repository.MainRepoSource
import com.example.jokeapplication.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JokesViewModel(private val repository: MainRepoSource) : ViewModel() {

    fun getJokes(): LiveData<List<Joke>> {
        return repository.getAllOldJokes()
    }

    fun getremoteJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNewJoke()
        }
    }

}