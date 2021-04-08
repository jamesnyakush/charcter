package com.example.e_movieapp.ui.movie.adapter

import com.example.e_movieapp.data.db.UserMovie

interface MovieItemClickListener {
    fun onItemClick(movies: UserMovie)
}