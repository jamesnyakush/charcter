package com.example.e_movieapp.data.repository

import com.example.e_movieapp.data.db.MovieDao
import com.example.e_movieapp.data.db.UserMovie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDao: MovieDao
) {

    suspend fun insertMovie(userMovie: UserMovie) = movieDao.insertMovies(userMovie)

    suspend fun fetchMovies() = movieDao.getAllMovies()
}