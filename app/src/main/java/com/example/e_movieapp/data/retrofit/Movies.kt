package com.example.e_movieapp.data.retrofit

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("title") var title: String,
    @SerializedName("year") var  year: String,
    @SerializedName("director") var director: String,
    @SerializedName("actors") var actors: String,
    @SerializedName("rate") var rate: String,
    @SerializedName("review") var review: String
)