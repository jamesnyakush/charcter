package com.example.e_movieapp.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.e_movieapp.data.db.models.UserMovie
import com.example.e_movieapp.databinding.ItemEditMovieBinding
import com.example.e_movieapp.databinding.ItemMovieBinding
import com.example.e_movieapp.ui.movie.fragment.EditMoviesDirections


class EditMovieAdapter(
    var movies: List<UserMovie>,
    var movieItemClickListener: MovieItemClickListener
) : RecyclerView.Adapter<EditMovieAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        ItemEditMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) = with(holder.binding) {

        val movie = movies[position]

        title.text = movie.title
        year.text = movie.year
        director.text = movie.director
        actors.text = movie.actors
        rate.text = movie.rate
        review.text = movie.review

        edit.setOnClickListener {

            val action = EditMoviesDirections.actionEditMoviesToOnEdit()
//            action.actionId.g = movies[position]
            Navigation.findNavController(it).navigate(action)
        }

    }

    class MoviesViewHolder(val binding: ItemEditMovieBinding) :
        RecyclerView.ViewHolder(binding.root)
}