package com.example.e_movieapp.data

import com.google.gson.annotations.SerializedName

data class UserMovieResponse(
    @SerializedName("userMovies") var userMovies: List<UserMovie>
)