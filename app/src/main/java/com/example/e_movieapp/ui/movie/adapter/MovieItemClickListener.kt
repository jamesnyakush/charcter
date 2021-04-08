package com.example.e_movieapp.ui.movie.adapter

import com.example.e_movieapp.data.db.models.UserMovie

interface MovieItemClickListener {
    fun onItemClick(movies: UserMovie)
}