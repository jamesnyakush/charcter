package com.example.e_movieapp.data.retrofit

import com.example.e_movieapp.data.db.models.UserMovie
import com.google.gson.annotations.SerializedName

data class UserMovieResponse(
    @SerializedName("userMovies") var userMovies: List<UserMovie>
)