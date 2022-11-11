package com.example.jokeapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jokeapplication.R
import com.example.jokeapplication.model.Joke
import kotlinx.android.synthetic.main.item_joke.view.*

class JokesAdapter(private val context: Context, private val jokes: List<Joke>) :
    RecyclerView.Adapter<JokesAdapter.JokeViewHolder>() {

    var list = listOf<Joke>()

    init {
        list = jokes
    }

    class JokeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_joke,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.itemView.tvJokee.text = list[position].joke
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(it: List<Joke>?) {
        list = it!!
        notifyDataSetChanged()
    }

}