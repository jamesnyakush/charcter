package com.example.e_movieapp.data.Api

import com.google.gson.annotations.SerializedName
data  class Search (
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Actor") val actors: String
)
