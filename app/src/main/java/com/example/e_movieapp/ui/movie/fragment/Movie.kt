package com.example.e_movieapp.ui.movie.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.e_movieapp.R
import com.example.e_movieapp.databinding.MovieFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Movie : Fragment(R.layout.movie_fragment), View.OnClickListener {

    private lateinit var binding: MovieFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = MovieFragmentBinding.bind(view)

        binding.btnRegisterMovie.setOnClickListener(this)
        binding.btnDisplayMovies.setOnClickListener(this)
        binding.btnFavorites.setOnClickListener(this)
        binding.btnEditMovies.setOnClickListener(this)
        binding.btnSearch.setOnClickListener(this)
        binding.btnRate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegisterMovie -> {
                val action = MovieDirections.actionMovieToRegisterMovie()
                Navigation.findNavController(v).navigate(action)
            }

            R.id.btnDisplayMovies -> {
                val action = MovieDirections.actionMovieToDisplayMovies()
                Navigation.findNavController(v).navigate(action)
            }

            R.id.btnFavorites -> {
                val action = MovieDirections.actionMovieToFavourites()
                Navigation.findNavController(v).navigate(action)
            }

            R.id.btnEditMovies -> {
                val action = MovieDirections.actionMovieToEditMovies()
                Navigation.findNavController(v).navigate(action)
            }

            R.id.btnSearch -> {
                val action = MovieDirections.actionMovieToRegisterMovie()
                Navigation.findNavController(v).navigate(action)
            }

            R.id.btnRate -> {
                val action = MovieDirections.actionMovieToRating()
                Navigation.findNavController(v).navigate(action)
            }
        }
    }
}