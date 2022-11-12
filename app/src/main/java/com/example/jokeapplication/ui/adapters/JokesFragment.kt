package com.example.jokeapplication.ui.adapters

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapplication.R
import org.koin.android.viewmodel.ext.android.viewModel

class JokesFragment : Fragment() {
    private val TAG = JokesFragment::class.java.simpleName
    private val jokesViewModel: JokesViewModel by viewModel()
    private lateinit var jokesAdapter: JokesAdapter
    private lateinit var navController: NavController
    lateinit var mainHandler: Handler

    private val fetchJokeTask = object : Runnable {
        override fun run() {
            getJokesInMinute()
            mainHandler.postDelayed(this, 60000)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_joke, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.rvJokes)


        navController = findNavController()
        jokesAdapter = JokesAdapter(recyclerView.context, listOf())
        recyclerView.adapter = jokesAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        mainHandler = Handler(Looper.getMainLooper())

        initJokeCall()

        return root
    }


    override fun onPause() {
        super.onPause()
        mainHandler.removeCallbacks(fetchJokeTask)
    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(fetchJokeTask)
    }

    private fun initJokeCall() {
        jokesViewModel.getJokes().observe(viewLifecycleOwner, Observer {
            if (it.size > 10) {
                jokesAdapter.setData(it.subList(it.size - 10, it.size))
            } else {
                jokesAdapter.setData(it)
            }
        })
    }

    fun getJokesInMinute() {
        jokesViewModel.getremoteJoke()
    }

}