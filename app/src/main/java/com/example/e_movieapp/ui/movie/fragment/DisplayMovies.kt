package com.example.e_movieapp.ui.movie.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_movieapp.R
import com.example.e_movieapp.data.db.models.UserMovie
import com.example.e_movieapp.databinding.DisplayMoviesFragmentBinding
import com.example.e_movieapp.ui.movie.adapter.MovieAdapter
import com.example.e_movieapp.ui.movie.adapter.MovieItemClickListener
import com.example.e_movieapp.ui.movie.viewmodel.MovieViewModel
import com.example.e_movieapp.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DisplayMovies : Fragment(R.layout.display_movies_fragment), MovieItemClickListener {

    private lateinit var binding: DisplayMoviesFragmentBinding
    private val viewModel by viewModels<MovieViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DisplayMoviesFragmentBinding.bind(view)


        viewModel.fetchMovies.observe(viewLifecycleOwner, Observer {
            binding.rvMovies.apply {
                layoutManager = LinearLayoutManager(requireContext())
                hasFixedSize()
                adapter = MovieAdapter(it, this@DisplayMovies)
            }
        })

        viewModel.fetchMovies()
    }


    override fun onItemClick(movies: UserMovie) {
        movies.isFavourite = true


        val test = viewModel.addFavourites(movies)

        context?.toast(test.toString())


    }
}