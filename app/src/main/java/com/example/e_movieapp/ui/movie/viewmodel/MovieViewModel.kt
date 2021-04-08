package com.example.e_movieapp.ui.movie.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_movieapp.data.repository.MovieRepository
import com.example.e_movieapp.data.db.models.UserMovie
import kotlinx.coroutines.launch


class MovieViewModel @ViewModelInject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _fetchMovies = MutableLiveData<List<UserMovie>>()
    val fetchMovies: LiveData<List<UserMovie>>
        get() = _fetchMovies

//    private val _fetchFavourites = MutableLiveData<List<Favourite>>()
//    val fetchFavourites: LiveData<List<Favourite>>
//        get() = _fetchFavourites


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
        _fetchMovies.value = repository.fetchMovies()
    }


    fun addFavourites(
        userMovie: UserMovie
    ) = viewModelScope.launch {
        repository.addFavourites(userMovie)
    }


/*    fun fetchFavourites() = viewModelScope.launch {
        _fetchFavourites.value = repository.fetchFavourites()
    }*/
}