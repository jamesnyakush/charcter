package com.example.e_movieapp.data.retrofit

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("message") var message: String,
    @SerializedName("movies") var movies: String,
    @SerializedName("userMovies") var usermovies:String
)


