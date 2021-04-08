package com.example.e_movieapp.ui.movie.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_movieapp.data.repository.MovieRepository
import com.example.e_movieapp.data.db.UserMovie
import kotlinx.coroutines.launch


class MovieViewModel @ViewModelInject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _fetchmovies = MutableLiveData<List<UserMovie>>()
    val fetchmovies: LiveData<List<UserMovie>>
        get() = _fetchmovies

    fun addMovie(
        title: String,
        year: String,
        director: String,
        actors: String,
        rate: String,
        review: String
    ) = viewModelScope.launch {
        repository.insertMovie(
            UserMovie(
                title,
                year,
                director,
                actors,
                rate,
                review
            )
        )
    }

    fun fetchMovies() = viewModelScope.launch {
        _fetchmovies.value = repository.fetchMovies()
    }
}