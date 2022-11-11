package com.example.jokeapplication.ui.adapters


import android.os.SystemClock
import android.util.Log
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
            Log.d("Fetching joke", "" + SystemClock.currentThreadTimeMillis())
            repository.getNewJoke()
        }
    }

}