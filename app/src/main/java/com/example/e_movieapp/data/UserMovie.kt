package com.example.e_movieapp.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UserMovies")
data class UserMovie(

    @PrimaryKey @NonNull @SerializedName("Movie_id") var MovieId: String,
    @SerializedName("Title") var title: String,
    @SerializedName("Year") var year: String,
    @SerializedName("Director") var director: Int,
    @SerializedName("Actors") var actors: Int,
    @SerializedName("Rate") var rate:String,
    @SerializedName("Review") var review: String
)