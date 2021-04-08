package com.example.e_movieapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class UserMovie(
    var title: String,
    var year: String,
    var director: String,
    var actors: String,
    var rate: String,
    var review: String
) {
    @PrimaryKey(autoGenerate = true)
    var movie_id: Int = 0

}