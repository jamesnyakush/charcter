package com.example.e_movieapp.ui.movie.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.e_movieapp.R
import com.example.e_movieapp.databinding.RegisterMovieFragmentBinding
import com.example.e_movieapp.ui.movie.viewmodel.MovieViewModel
import com.example.e_movieapp.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class RegisterMovie : Fragment(R.layout.register_movie_fragment) {

    private lateinit var binding: RegisterMovieFragmentBinding
    private val viewModel by viewModels<MovieViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = RegisterMovieFragmentBinding.bind(view)

        binding.btnSave.setOnClickListener {
            onRegisterMovie()
        }

    }

    private fun onRegisterMovie() {
        val title = binding.edTitle.text.toString()
        val year = binding.edYear.text.toString()
        val director = binding.edDirector.text.toString()
        val rate = binding.edratings.text.toString()
        val review = binding.edReview.text.toString()
        val actors = binding.edActers.text.toString()

        if (title.isEmpty() || year.isEmpty() || director.isEmpty() || rate.isEmpty() || review.isEmpty() || actors.isEmpty()) {
            context?.toast("All Fields are  Required...")
        }



        lifecycleScope.launch {

            viewModel.addMovie(
                title,
                year,
                director,
                actors,
                rate,
                review
            )
        }
    }
}